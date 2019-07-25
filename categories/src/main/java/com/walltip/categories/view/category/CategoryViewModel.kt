package com.walltip.categories.view.category

import android.app.Application
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.palette.graphics.Palette
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.walltip.repository.data.Repository
import com.walltip.repository.data.source.model.CategoryState
import com.walltip.repository.data.source.model.UnsplashResult
import com.walltip.repository.data.source.model.UnsplashState
import javax.inject.Inject


class CategoryViewModel @Inject constructor(
    private val repository: Repository, application: Application
) : AndroidViewModel(application) {
 
    private val mutableLiveData: MutableLiveData<CategoryViewState> = MutableLiveData()
    private val unsplashLiveData: MutableLiveData<UnsplashViewState> = MutableLiveData()

    val categoryViewState: LiveData<CategoryViewState>
        get() = mutableLiveData

    val unsplashViewState: LiveData<UnsplashViewState>
        get() = unsplashLiveData
 
    init {
        load()
    }
 
    private fun load() {
        repository.getCategories { artistsState ->
            mutableLiveData.value = when (artistsState) {
                CategoryState.Loading -> CategoryViewState.InProgress
                is CategoryState.Error -> CategoryViewState.ShowError(artistsState.message)
                is CategoryState.Success -> CategoryViewState.ShowCategories(
                    artistsState.artists
                )
            }
        }
    }

    fun getPhotosByCategory(category: String){
        repository.getPhotos(hashMapOf("query" to category)) { unsplashState ->
            unsplashLiveData.value = when (unsplashState) {
                UnsplashState.Loading -> UnsplashViewState.InProgress
                is UnsplashState.Error -> UnsplashViewState.ShowError(unsplashState.message)
                is UnsplashState.Success -> UnsplashViewState.ShowCategories(
                    unsplashState.unsplashResult
                )
            }
        }
    }

    fun setPaletteColor(bitmap: Bitmap, onColorExtracted: (Int) -> Unit){

        Palette.from(bitmap).generate { palette ->
            //work with the palette here
            val defaultValue = 0x000000
            if(palette != null) {
                val mutedDark = palette.getDarkMutedColor(defaultValue)
                onColorExtracted(mutedDark)
            }
        }
    }

    fun getDrawable(category: String): Drawable?{
        when (category) {
            "Positivity" -> return (ContextCompat.getDrawable(getApplication(), com.walltip.categories.R.drawable.cloud))
            "Travel" -> return (ContextCompat.getDrawable(getApplication(), com.walltip.categories.R.drawable.compass))
            "Inspiration" -> return (ContextCompat.getDrawable(getApplication(), com.walltip.categories.R.drawable.camera))
            "Lifestyle" -> return (ContextCompat.getDrawable(getApplication(), com.walltip.categories.R.drawable.lips))
            "Relations" -> return (ContextCompat.getDrawable(getApplication(), com.walltip.categories.R.drawable.lock))
            "Health" -> return (ContextCompat.getDrawable(getApplication(), com.walltip.categories.R.drawable.cardiogram))
            "Time" -> return (ContextCompat.getDrawable(getApplication(), com.walltip.categories.R.drawable.hourglass))
            "Learn" -> return (ContextCompat.getDrawable(getApplication(), com.walltip.categories.R.drawable.manual))
            "Nature" -> return (ContextCompat.getDrawable(getApplication(), com.walltip.categories.R.drawable.leaves))
        }
        return null
    }

    fun applyBackground(imageUrl: String, onColorExtracted: (Int) -> Unit){
        Glide.with(getApplication() as Application)
            .asBitmap()
            .load(imageUrl)
            .into(object : CustomTarget<Bitmap>(){
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    setPaletteColor(resource, onColorExtracted)
                }
                override fun onLoadCleared(placeholder: Drawable?) {
                    // this is called when imageView is cleared on lifecycle call or for
                    // some other reason.
                    // if you are referencing the bitmap somewhere else too other than this imageView
                    // clear it here as you can no longer have the bitmap
                }
            })
    }

    fun getImageList(results: List<UnsplashResult.Result>): Pair<List<String>, List<String>> {
        val smallImages = arrayListOf<String>()
        val regularImages = arrayListOf<String>()
        results.forEach { t: UnsplashResult.Result ->
            smallImages.add(t.urls?.small.orEmpty())
            regularImages.add(t.urls?.regular.orEmpty())
        }
        return Pair(smallImages, regularImages)
    }

    fun getInitialData(): List<String>{
        val list: List<String> by lazy(LazyThreadSafetyMode.PUBLICATION) {
            listOf(
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
        }

        return list
    }
}