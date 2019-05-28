package com.walltip.categories.view.category

import com.walltip.repository.data.source.model.UnsplashResult


sealed class UnsplashViewState {

    object InProgress : UnsplashViewState()

    class ShowCategories(val unsplashResult: UnsplashResult) : UnsplashViewState()

    class ShowError(val message: String) : UnsplashViewState()
}