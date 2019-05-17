package com.walltip.categories.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.walltip.categories.R
import com.walltip.categories.adapter.CategoryDetailAdapter
import com.walltip.categories.util.InsetDecoration
import kotlinx.android.synthetic.main.activity_category_detail.*


class CategoryDetailActivity: AppCompatActivity() {

    private lateinit var categoryDetailAdapter: CategoryDetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_detail)

        categoryDetailAdapter = CategoryDetailAdapter()

        recyclerView.apply {
            adapter = categoryDetailAdapter
            layoutManager = GridLayoutManager(context, 3, RecyclerView.VERTICAL, false)
            addItemDecoration(InsetDecoration(context))

            setHasFixedSize(true)
        }


        categoryTV.text = "Productivity"
        countTV.text = "13 Walltips"
        iconIV.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.cloud))

        categoryDetailAdapter.swapData(getInitialData())
    }

    fun getInitialData(): List<String>{
        val imageList = listOf(
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
        )
        return imageList
    }
}