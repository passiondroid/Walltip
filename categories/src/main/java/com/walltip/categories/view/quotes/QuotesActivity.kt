package com.walltip.categories.view.quotes

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View.*
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

        val alpha = PropertyValuesHolder.ofFloat(ALPHA, 1f)
        val translation = PropertyValuesHolder.ofFloat(TRANSLATION_Y, 600f)
        val scaleX = PropertyValuesHolder.ofFloat(SCALE_X, 1.5f)
        val scaleY = PropertyValuesHolder.ofFloat(SCALE_Y, 1.5f)

        val animator = ObjectAnimator.ofPropertyValuesHolder(tapView, alpha, translation, scaleX, scaleY)
        animator.apply {
                repeatCount = ValueAnimator.INFINITE
                duration = 1800L
                start()
        }

    }


}