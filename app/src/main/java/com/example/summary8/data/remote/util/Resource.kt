package com.example.summary8.data.remote.util

sealed class Resource<out R> {
    data class Success<out R : Any>(val data: R) : Resource<R>()
    data class Error<out R : Any>(val errorMessage: String) : Resource<R>()
}