package com.walltip.categories.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.walltip.categories.R
import com.walltip.categories.data.model.Category
import kotlinx.android.synthetic.main.layout_category_item.view.*

class CategoryAdapter : ListAdapter<Category, CategoryAdapter.ItemViewholder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewholder {
        return ItemViewholder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_category_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewholder, position: Int) {
        holder.bind(getItem(position))
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

            if(item.title == "Positivity"){
                iconIV.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.cloud))
            } else if (item.title == "Travel"){
                iconIV.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.compass))
            } else if (item.title == "Inspiration"){
                iconIV.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.camera))
            } else if (item.title == "Lifestyle"){
                iconIV.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.lips))
            } else if (item.title == "Relations"){
                iconIV.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.lock))
            } else if (item.title == "Health"){
                iconIV.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.cardiogram))
            } else if (item.title == "Time"){
                iconIV.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.hourglass))
            } else if (item.title == "Learn"){
                iconIV.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.manual))
            } else if (item.title == "Nature"){
                iconIV.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.leaves))
            }

            setOnClickListener {
                // TODO: Handle on click
            }
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.count == newItem.count
    }
}
