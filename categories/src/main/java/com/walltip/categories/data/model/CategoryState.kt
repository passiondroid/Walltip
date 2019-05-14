package com.walltip.categories.data.model

sealed class CategoryState {

    object Loading : CategoryState()

    class Success(val artists: List<Category>) : CategoryState()

    class Error(val message: String) : CategoryState()
}