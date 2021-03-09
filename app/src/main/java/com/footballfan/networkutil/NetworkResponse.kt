package com.footballfan.networkutil

sealed class NetworkResponse<out T : Any>

sealed class NetworkNoResult : NetworkResponse<Nothing>()

object NetworkUnavailable : NetworkNoResult()

object NetworkIOError : NetworkNoResult()

class NetworkHttpError(val errorCode: Int) : NetworkNoResult()

class NetworkResult<out T : Any>(val result: T) : NetworkResponse<T>()