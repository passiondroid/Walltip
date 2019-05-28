package com.walltip.categories.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.walltip.categories.R
import com.walltip.categories.view.category.CategoryDetailActivity
import kotlinx.android.synthetic.main.layout_category_item.view.*
import androidx.core.util.Pair
import com.walltip.core.util.Constants
import com.walltip.repository.data.source.model.Category


class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.ItemViewholder>() {

    private var data: List<Category> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewholder {
        return ItemViewholder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_category_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewholder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    fun swapData(data: List<Category>) {
        this.data = data
        notifyDataSetChanged()
    }

    class ItemViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Category) = with(itemView) {
            Glide
                .with(this)
                .load(item.imageUrl)
                .centerCrop()
                .into(categoryIV)
            categoryTV.text = item.title
            countTV.text = item.count

            when {
                item.title == "Positivity" -> iconIV.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.cloud))
                item.title == "Travel" -> iconIV.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.compass))
                item.title == "Inspiration" -> iconIV.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.camera))
                item.title == "Lifestyle" -> iconIV.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.lips))
                item.title == "Relations" -> iconIV.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.lock))
                item.title == "Health" -> iconIV.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.cardiogram))
                item.title == "Time" -> iconIV.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.hourglass))
                item.title == "Learn" -> iconIV.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.manual))
                item.title == "Nature" -> iconIV.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.leaves))
            }

            setOnClickListener {
                val p1 = Pair(iconIV as View, "icon")
                val p2 = Pair(categoryTV as View, "category")
                val p3 = Pair(countTV as View, "count")
                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this.context as Activity, p1,p2,p3)
                val intent = Intent(it.context, CategoryDetailActivity::class.java)
                intent.putExtra(Constants.COUNT, item.count)
                intent.putExtra(Constants.CATEGORY, item.title)
                intent.putExtra(Constants.IMAGE_URL, item.imageUrl)
                it.context.startActivity(intent, options.toBundle())
            }
        }
    }
}

