package com.walltip.repository.data

import com.walltip.repository.data.source.model.CategoryState
import com.walltip.repository.data.source.model.UnsplashState

/**
 * Created by Arif Khan on 2019-05-18.
 */
interface DataSource {

    fun getPhotos(params: HashMap<String, String>, callback: (UnsplashState) -> Unit)

    fun getCategories(callback: (CategoryState) -> Unit)
}