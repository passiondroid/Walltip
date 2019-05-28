package com.walltip.repository.data

import com.walltip.core.app.ConnectivityChecker
import com.walltip.repository.data.source.model.CategoryState
import com.walltip.repository.data.source.model.UnsplashState
import com.walltip.repository.data.source.remote.RemoteDataSource

/**
 * Created by Arif Khan on 2019-05-18.
 */
class Repository
constructor(private val remoteDataSource: RemoteDataSource, private val connectivityChecker: ConnectivityChecker) :
    DataSource {

    override fun getPhotos(params: HashMap<String, String>, callback: (UnsplashState) -> Unit) {
        if (!isInternetAvailable()) {
            callback(UnsplashState.Error("No network connectivity"))
            return
        }
        remoteDataSource.getPhotos(params, callback)
    }

    override fun getCategories(callback: (CategoryState) -> Unit) {
        if (!isInternetAvailable()) {
            callback(CategoryState.Error("No network connectivity"))
            return
        }
        remoteDataSource.getCategories(callback)
    }

    private fun isInternetAvailable(): Boolean{
        return connectivityChecker.isConnected
    }

}
