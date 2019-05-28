package com.walltip.repository.data.source.api

import com.walltip.repository.data.source.model.Category
import retrofit2.Call
import retrofit2.http.GET

interface CategoryApi {

    @GET("passiondroid/walltip/categories")
    fun getCategories(): Call<List<Category>>
}