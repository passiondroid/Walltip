package com.walltip.categories.view.category

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.walltip.categories.R
import com.walltip.categories.adapter.CategoryAdapter
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_category.*
import javax.inject.Inject
import androidx.core.content.ContextCompat
import com.walltip.categories.util.DividerItemDecoration
import com.walltip.core.analytics.Tracker
import com.walltip.repository.data.source.model.Category


class CategoryActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    var tracker =  Tracker

    private lateinit var categoryViewModel: CategoryViewModel
    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        categoryViewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(CategoryViewModel::class.java)
        categoryAdapter = CategoryAdapter()

        val dividerDrawable = ContextCompat.getDrawable(this, R.drawable.divider)

        recyclerView.apply {
            adapter = categoryAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            addItemDecoration(DividerItemDecoration(dividerDrawable))
            setHasFixedSize(true)
        }

        categoryViewModel.categoryViewState.observe(this, Observer { newState -> viewStateChanged(newState) })

        val hashMap = HashMap<String,String>()
        hashMap.put("data","Category Activity")

        tracker.trackClickEvents("Page",hashMap)

    }

    private fun viewStateChanged(categoryViewState: CategoryViewState) {
        when (categoryViewState) {
            is CategoryViewState.InProgress -> setLoading()
            is CategoryViewState.ShowError -> setError(categoryViewState.message)
            is CategoryViewState.ShowCategories -> updateCategories(categoryViewState.categories)
        }
    }

    private fun setLoading() {
        progress.visibility = View.VISIBLE
        errorMessageTV.visibility = View.GONE
        recyclerView.visibility = View.GONE
    }

    private fun setError(message: String) {
        progress.visibility = View.GONE
        errorMessageTV.visibility = View.VISIBLE
        errorMessageTV.text = message
        recyclerView.visibility = View.GONE
    }

    private fun updateCategories(categories: List<Category>) {
        progress.visibility = View.GONE
        errorMessageTV.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
        categoryAdapter.swapData(categories)
    }
}
