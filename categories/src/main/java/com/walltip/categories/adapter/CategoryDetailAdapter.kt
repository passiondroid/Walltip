package com.walltip.categories.adapter

import android.content.Intent
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.walltip.categories.R
import com.walltip.categories.view.quotes.QuotesActivity
import com.walltip.core.util.Constants
import com.walltip.core.util.gone
import kotlinx.android.synthetic.main.layout_category_detail_item.view.*


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
                    .listener(object: RequestListener<Drawable>{
                        override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                            return false
                        }

                        override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?,
                                                     isFirstResource: Boolean): Boolean {
                            loader.gone()
                            return false
                        }
                    })
                    .transition(DrawableTransitionOptions.withCrossFade())
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

