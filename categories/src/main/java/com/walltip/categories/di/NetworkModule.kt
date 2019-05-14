package com.walltip.categories.di

import com.walltip.categories.data.api.CategoryApi
import com.walltip.core.di.CoreNetworkModule
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

//    @Provides
//    @Named("API_KEY")
//    @JvmStatic
//    internal fun providesApiKey() =
//        Interceptor { chain ->
//            val newRequest = chain.request().let { request ->
//                val newUrl = request.url().newBuilder()
//                    .addQueryParameter("api_key", BuildConfig.LAST_FM_APIKEY)
//                    .build()
//                request.newBuilder()
//                    .url(newUrl)
//                    .build()
//            }
//            chain.proceed(newRequest)
//        }

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
//        @Named("API_KEY") apiKeyInterceptor: Interceptor,
        @Named("JSON") jsonInterceptor: Interceptor
    ): OkHttpClient =
//        builder.addInterceptor(apiKeyInterceptor)
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
    @JvmStatic
    internal fun providesCategoryApi(retrofit: Retrofit): CategoryApi =
        retrofit.create(CategoryApi::class.java)

}
