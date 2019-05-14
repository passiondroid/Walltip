package com.walltip.categories.data.api

import com.walltip.categories.data.model.Category
import retrofit2.Call
import retrofit2.http.GET

interface CategoryApi {

    @GET("passiondroid/walltip/categories")
    fun getCategories(): Call<List<Category>>
}