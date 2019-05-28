package com.walltip.repository.data.source.remote

import com.walltip.core.util.Constants
import com.walltip.repository.BuildConfig
import com.walltip.repository.data.source.api.CategoryApi
import com.walltip.repository.data.source.api.UnsplashApi
import com.walltip.repository.data.source.model.Category
import com.walltip.repository.data.source.model.CategoryState
import com.walltip.repository.data.DataSource
import com.walltip.repository.data.source.model.UnsplashResult
import com.walltip.repository.data.source.model.UnsplashState
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Arif Khan on 2019-05-18.
 */
class RemoteDataSource @Inject
constructor (private val categoryApi: CategoryApi, private val unsplashApi: UnsplashApi): DataSource {

    override fun getPhotos(params: HashMap<String, String>, callback: (UnsplashState) -> Unit) {
        callback(UnsplashState.Loading)
        params[Constants.PAGE] = (1..100).shuffled().first().toString()
        params[Constants.CLIENT_ID] = BuildConfig.UnsplashClientId
        unsplashApi.getPhotos(params).enqueue(object : Callback<UnsplashResult> {
            override fun onFailure(call: Call<UnsplashResult>, t: Throwable) {
                callback(UnsplashState.Error(t.localizedMessage))
            }

            override fun onResponse(call: Call<UnsplashResult>, response: Response<UnsplashResult>) {
                response.body()?.also {
                    callback(UnsplashState.Success(it))
                }
            }
        })
    }

    override fun getCategories(callback: (CategoryState) -> Unit) {
        callback(CategoryState.Loading)
        categoryApi.getCategories().enqueue(object : Callback<List<Category>> {
            override fun onFailure(call: Call<List<Category>>, t: Throwable) {
                callback(CategoryState.Error(t.localizedMessage))
            }

            override fun onResponse(call: Call<List<Category>>, response: Response<List<Category>>) {
                response.body()?.also {
                    callback(CategoryState.Success(it))
                }
            }
        })
    }


}