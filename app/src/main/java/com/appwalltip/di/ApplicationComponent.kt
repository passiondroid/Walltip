package com.appwalltip.di

import com.appwalltip.WalltipApplication
import com.walltip.categories.di.CategoryModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ApplicationModule::class,
        ActivityModule::class,
        CategoryModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<WalltipApplication> {
 
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<WalltipApplication>()
}