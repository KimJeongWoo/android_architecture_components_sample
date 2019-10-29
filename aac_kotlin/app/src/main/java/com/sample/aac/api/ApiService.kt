package com.sample.aac.api

import com.sample.aac.data.model.BaseResponse
import com.sample.aac.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET


interface ApiService {
    @GET("users/list")
    fun getUserData(): Call<UserResponse>

    @GET("34k1jlkj4lk12j4lk12j4")
    fun getError(): Call<BaseResponse>
}