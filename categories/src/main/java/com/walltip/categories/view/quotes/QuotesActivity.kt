package com.walltip.categories.view.quotes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.walltip.categories.R
import com.walltip.core.util.Constants
import kotlinx.android.synthetic.main.layout_activity_quotes.*


/**
 * Created by Arif Khan on 2019-05-19.
 */
class QuotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_activity_quotes)
        val imageUrl = intent.getStringExtra(Constants.IMAGE_URL_REGULAR)

        Glide.with(this)
            .load(imageUrl)
            .centerCrop()
            .into(walltipIV)


    }


}