package com.walltip.categories.view

import com.walltip.categories.data.model.Category

sealed class CategoryViewState {

    object InProgress : CategoryViewState()

    class ShowCategories(val categories: List<Category>) : CategoryViewState()

    class ShowError(val message: String) : CategoryViewState()
}