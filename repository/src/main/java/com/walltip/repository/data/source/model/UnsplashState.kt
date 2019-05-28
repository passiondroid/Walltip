package com.walltip.repository.data.source.model

sealed class UnsplashState {

    object Loading : UnsplashState()

    class Success(val unsplashResult: UnsplashResult) : UnsplashState()

    class Error(val message: String) : UnsplashState()
}