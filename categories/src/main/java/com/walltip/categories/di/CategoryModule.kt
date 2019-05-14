package com.walltip.categories.di

import androidx.lifecycle.ViewModel
import com.walltip.categories.view.CategoryActivity
import com.walltip.categories.view.CategoryViewModel
import com.walltip.core.di.BaseViewModule
import com.walltip.core.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module(
    includes = [
        NetworkModule::class,
        BaseViewModule::class,
        CateogryRepositoryModule::class
    ]
)
@Suppress("unused")
abstract class CategoryModule {

    @ContributesAndroidInjector
    abstract fun bindCategoryActivity(): CategoryActivity

    @Binds
    @IntoMap
    @ViewModelKey(CategoryViewModel::class)
    abstract fun bindCategoryViewModel(viewModel: CategoryViewModel): ViewModel

}