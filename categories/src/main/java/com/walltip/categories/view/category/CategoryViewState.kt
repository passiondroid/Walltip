package com.walltip.categories.view.category

import com.walltip.repository.data.source.model.Category


sealed class CategoryViewState {

    object InProgress : CategoryViewState()

    class ShowCategories(val categories: List<Category>) : CategoryViewState()

    class ShowError(val message: String) : CategoryViewState()
}