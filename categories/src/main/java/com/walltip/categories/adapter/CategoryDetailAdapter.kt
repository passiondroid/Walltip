package com.walltip.categories.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.walltip.categories.R
import com.walltip.categories.view.quotes.QuotesActivity
import com.walltip.core.util.Constants
import kotlinx.android.synthetic.main.layout_category_detail_item.view.*
import android.graphics.Bitmap
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.bumptech.glide.request.target.CustomViewTarget
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition


class CategoryDetailAdapter : RecyclerView.Adapter<CategoryDetailAdapter.ItemViewholder>() {

    private var smallImagesData: List<String> = ArrayList()
    private var regularImagesData: List<String> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewholder {
        return ItemViewholder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_category_detail_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewholder, position: Int) {
        holder.bind(smallImagesData[position], regularImagesData[position])
    }

    override fun getItemCount() = smallImagesData.size

    fun swapData(pair: Pair<List<String>, List<String>>) {
        this.smallImagesData = pair.first
        this.regularImagesData = pair.second
        notifyDataSetChanged()
    }

    class ItemViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(smallImageUrl: String, regularImageUrl: String) = with(itemView) {

            if(smallImageUrl.isNotEmpty()) {
                Glide.with(this)
                    .load(smallImageUrl)
                    .centerCrop()
                    .into(wallIV)

                //Load regular image silently
                val requestManager = Glide.with(context)
                requestManager.load(regularImageUrl).submit()
            }

            setOnClickListener {
                val intent = Intent(context, QuotesActivity::class.java)
                intent.putExtra(Constants.IMAGE_URL_REGULAR, regularImageUrl)
                context.startActivity(intent)
            }
        }
    }
}

