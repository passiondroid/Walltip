package com.appwalltip

import com.appwalltip.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.crashes.Crashes


class WalltipApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerApplicationComponent.builder().create(this)

    override fun onCreate() {
        super.onCreate()

        AppCenter.start(this, "a14c2cad-1eac-42bc-a3f3-b5ec92402447", Analytics::class.java,
            Crashes::class.java)

    }
}