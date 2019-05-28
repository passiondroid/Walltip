package com.walltip.repository.data.source.api

import com.walltip.repository.data.source.model.UnsplashResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface UnsplashApi {

    @GET("search/photos")
    fun getPhotos(@QueryMap map: Map<String, String>): Call<UnsplashResult>
}