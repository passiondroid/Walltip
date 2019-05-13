package com.walltip.core.providers

interface DataMapper<S, R> {
    fun map(source: S): R
}