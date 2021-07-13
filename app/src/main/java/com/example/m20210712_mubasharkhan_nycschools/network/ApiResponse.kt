package com.example.m20210712_mubasharkhan_nycschools.network;

data class ApiResponse<out T> (val status: Status, val data : T?, val message: String?) {
    companion object {
        fun <T> loading () : ApiResponse<T> = ApiResponse(status = Status.LOADING, data = null, message = null)
        fun <T> success (data : T) : ApiResponse<T> = ApiResponse(status = Status.SUCCESS, data = data, message = null)
        fun <T> error (message: String) : ApiResponse<T> = ApiResponse(status = Status.ERROR, data = null, message = message)
    }
}