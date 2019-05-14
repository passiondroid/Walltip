package com.walltip.categories.data

import com.walltip.categories.data.api.CategoryApi
import com.walltip.categories.data.model.CategoryState
import com.walltip.categories.data.model.Category
import com.walltip.core.app.ConnectivityChecker
import com.walltip.core.providers.DataProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryProvider(
    private val categoryApi: CategoryApi,
    private val connectivityChecker: ConnectivityChecker
) : DataProvider<CategoryState> {

    override fun requestData(callback: (topArtists: CategoryState) -> Unit) {
        if (!connectivityChecker.isConnected) {
            callback(CategoryState.Error("No network connectivity"))
            return
        }
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