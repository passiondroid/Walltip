package com.appwalltip.di

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import com.appwalltip.SplashActivity
import com.appwalltip.WalltipApplication
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module
object ApplicationModule {

    @Provides
    @JvmStatic
    @Singleton
    internal fun provideApplication(app: WalltipApplication): Application = app

    @Provides
    @JvmStatic
    @Singleton
    fun providesConnectivityManager(app: Application): ConnectivityManager =
        app.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

}