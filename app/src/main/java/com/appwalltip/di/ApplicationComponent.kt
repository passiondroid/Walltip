package com.appwalltip.di

import com.appwalltip.WalltipApplication
import com.walltip.categories.di.CategoriesModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Component(
    modules = [
        AndroidInjectionModule::class,
        ApplicationModule::class,
        ActivityModule::class,
        CategoriesModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<WalltipApplication> {
 
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<WalltipApplication>()
}