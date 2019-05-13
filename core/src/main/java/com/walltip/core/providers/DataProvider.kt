package com.walltip.core.providers

interface DataProvider<T> {

    fun requestData(callback: (item: T) -> Unit)
}