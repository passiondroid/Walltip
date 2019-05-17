package com.walltip.categories.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.walltip.categories.R
import com.walltip.categories.data.model.Category
import com.walltip.categories.view.CategoryDetailActivity
import kotlinx.android.synthetic.main.layout_category_item.view.*

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
                it.context.startActivity(Intent(it.context,CategoryDetailActivity::class.java))
            }
        }
    }
}

