package com.walltip.categories.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.walltip.categories.R
import kotlinx.android.synthetic.main.layout_category_detail_item.view.*

class CategoryDetailAdapter : RecyclerView.Adapter<CategoryDetailAdapter.ItemViewholder>() {

    private var data: List<String> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewholder {
        return ItemViewholder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_category_detail_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewholder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    fun swapData(data: List<String>) {
        this.data = data
        notifyDataSetChanged()
    }

    class ItemViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: String) = with(itemView) {
//            Glide
//                .with(this)
//                .load(item)
//                .centerCrop()
//                .into(wallIV)


            setOnClickListener {
                // TODO: Handle on click
            }
        }
    }
}

