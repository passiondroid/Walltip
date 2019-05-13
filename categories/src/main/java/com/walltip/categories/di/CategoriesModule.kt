package com.walltip.categories.di

import com.walltip.categories.view.CategoryActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class CategoriesModule {

    @ContributesAndroidInjector(
        modules = [NetworkModule::class]
    )
    abstract fun bindCategoryActivity(): CategoryActivity

}