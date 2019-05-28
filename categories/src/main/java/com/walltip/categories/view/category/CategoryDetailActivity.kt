package com.walltip.categories.view.category

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.walltip.categories.R
import com.walltip.categories.adapter.CategoryDetailAdapter
import com.walltip.categories.util.InsetDecoration
import kotlinx.android.synthetic.main.activity_category_detail.*
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.walltip.core.util.Constants
import com.walltip.core.util.showAlertDialog
import com.walltip.core.util.visible
import com.walltip.repository.data.source.model.UnsplashResult
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject




class CategoryDetailActivity: DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var categoryViewModel: CategoryViewModel
    private lateinit var categoryDetailAdapter: CategoryDetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_detail)
        categoryViewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(CategoryViewModel::class.java)

        categoryDetailAdapter = CategoryDetailAdapter()

        recyclerView.apply {
            adapter = categoryDetailAdapter
            layoutManager = GridLayoutManager(context, 3, RecyclerView.VERTICAL, false)
            addItemDecoration(InsetDecoration(context))

            setHasFixedSize(true)
        }

        categoryTV.text = intent.getStringExtra(Constants.CATEGORY)
        countTV.text = intent.getStringExtra(Constants.COUNT)
        val imageUrl = intent.getStringExtra(Constants.IMAGE_URL)
        iconIV.setImageDrawable(categoryViewModel.getDrawable(categoryTV.text.toString()))

        categoryViewModel.applyBackground(imageUrl) {
            rootLayout.setBackgroundColor(it)
        }

        categoryDetailAdapter.swapData(Pair(categoryViewModel.getInitialData(), categoryViewModel.getInitialData()))

        categoryViewModel.unsplashViewState.observe(this, Observer { newState -> viewStateChanged(newState) })

        categoryViewModel.getPhotosByCategory(categoryTV.text.toString())

    }

//    override fun onEnterAnimationComplete() {
//        super.onEnterAnimationComplete()
//        categoryViewModel.getPhotosByCategory(categoryTV.text.toString())
//    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                supportFinishAfterTransition()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun viewStateChanged(unsplashViewState: UnsplashViewState) {
        when (unsplashViewState) {
            is UnsplashViewState.ShowError -> setError(unsplashViewState.message)
            is UnsplashViewState.ShowCategories -> updatePhotos(unsplashViewState.unsplashResult)
        }
    }

    private fun setError(message: String) {
        showAlertDialog(message)
    }

    private fun updatePhotos(unsplashResult: UnsplashResult) {
        recyclerView.visible()
        categoryDetailAdapter.swapData(categoryViewModel.getImageList(unsplashResult.results))
    }

    override fun onDestroy() {
        super.onDestroy()
        supportFinishAfterTransition()
    }
}