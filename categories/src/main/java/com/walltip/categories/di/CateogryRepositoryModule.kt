package com.walltip.categories.di

import com.walltip.categories.data.CategoryProvider
import com.walltip.categories.data.api.CategoryApi
import com.walltip.categories.data.model.CategoryState
import com.walltip.core.app.ConnectivityChecker
import com.walltip.core.providers.DataProvider
import dagger.Module
import dagger.Provides

@Module
object CateogryRepositoryModule {
 
    @Provides
    @JvmStatic
    fun providesCategoryProvider(
        categoryApi: CategoryApi,
        connectivityChecker: ConnectivityChecker
    ): DataProvider<CategoryState> =
        CategoryProvider(
            categoryApi,
            connectivityChecker
        )

}