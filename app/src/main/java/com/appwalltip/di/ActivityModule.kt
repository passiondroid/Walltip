package com.appwalltip.di

import com.appwalltip.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun bindMuseleeActivity(): SplashActivity

}