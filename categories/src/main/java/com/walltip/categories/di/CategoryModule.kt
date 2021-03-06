package com.walltip.categories.di

import androidx.lifecycle.ViewModel
import com.walltip.categories.view.category.CategoryActivity
import com.walltip.categories.view.category.CategoryDetailActivity
import com.walltip.categories.view.category.CategoryViewModel
import com.walltip.core.di.BaseViewModule
import com.walltip.core.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module(
    includes = [
        BaseViewModule::class
    ]
)
@Suppress("unused")
abstract class CategoryModule {

    @ContributesAndroidInjector
    abstract fun bindCategoryActivity(): CategoryActivity

    @ContributesAndroidInjector
    abstract fun bindCategoryDetailActivity(): CategoryDetailActivity

    @Binds
    @IntoMap
    @ViewModelKey(CategoryViewModel::class)
    abstract fun bindCategoryViewModel(viewModel: CategoryViewModel): ViewModel

}