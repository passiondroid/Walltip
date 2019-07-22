package com.walltip.repository.di

import com.walltip.core.di.CoreNetworkModule
import com.walltip.repository.data.source.api.CategoryApi
import com.walltip.repository.data.source.api.UnsplashApi
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [CoreNetworkModule::class])
object NetworkModule {

    @Provides
    @Named("JSON")
    @JvmStatic
    internal fun providesJson() =
        Interceptor { chain ->
            val newRequest = chain.request().let { request ->
                val newUrl = request.url().newBuilder()
                    .addQueryParameter("format", "json")
                    .build()
                request.newBuilder()
                    .url(newUrl)
                    .build()
            }
            chain.proceed(newRequest)
        }

    @Provides
    @JvmStatic
    internal fun providesOkHttpClient(
        builder: OkHttpClient.Builder,
        @Named("JSON") jsonInterceptor: Interceptor
    ): OkHttpClient =
        builder.addInterceptor(jsonInterceptor)
            .build()

    @Provides
    @Singleton
    @JvmStatic
    internal fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    @Provides
    @Singleton
    @JvmStatic
    @UnsplashRetrofit
    internal fun providesUnsplashRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://api.unsplash.com/")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    @Provides
    @Singleton
    @JvmStatic
    internal fun providesCategoryApi(retrofit: Retrofit): CategoryApi =
        retrofit.create(CategoryApi::class.java)

    @Provides
    @Singleton
    @JvmStatic
    internal fun providesUnsplashApi(@UnsplashRetrofit retrofit: Retrofit): UnsplashApi =
        retrofit.create(UnsplashApi::class.java)

}
