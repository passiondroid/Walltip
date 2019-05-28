package com.walltip.repository.di

import com.walltip.core.app.ConnectivityChecker
import com.walltip.repository.data.Repository
import com.walltip.repository.data.source.remote.RemoteDataSource
import dagger.Module
import dagger.Provides

@Module
object RepositoryModule {

    @Provides
    @JvmStatic
    fun providesRepository(
        remoteDataSource: RemoteDataSource,
        connectivityChecker: ConnectivityChecker
    ): Repository =
        Repository(remoteDataSource, connectivityChecker)

}