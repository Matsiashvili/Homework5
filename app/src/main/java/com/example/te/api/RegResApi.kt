package com.example.te.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface RegResApi {

    @Headers("x-api-key: reqres-free-v1")

    @GET("users")
    fun getUsers(@Query("page")page: Int) :Call<RegResObj<List<Person>>>

}