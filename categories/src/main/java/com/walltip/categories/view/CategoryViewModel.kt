package com.walltip.categories.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.walltip.categories.data.model.CategoryState
import com.walltip.core.providers.DataProvider
import javax.inject.Inject

class CategoryViewModel @Inject constructor(
    private val categoryProvider: DataProvider<CategoryState>
) : ViewModel() {
 
    private val mutableLiveData: MutableLiveData<CategoryViewState> = MutableLiveData()
    val categoryViewState: LiveData<CategoryViewState>
        get() = mutableLiveData
 
    init {
        load()
    }
 
    fun load() {
        categoryProvider.requestData { artistsState ->
            mutableLiveData.value = when (artistsState) {
                CategoryState.Loading -> CategoryViewState.InProgress
                is CategoryState.Error -> CategoryViewState.ShowError(artistsState.message)
                is CategoryState.Success -> CategoryViewState.ShowCategories(artistsState.artists)
            }
        }
    }
}