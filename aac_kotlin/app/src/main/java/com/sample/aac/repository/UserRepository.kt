package com.sample.aac.repository

import androidx.lifecycle.LiveData
import com.sample.aac.api.ApiService
import com.sample.aac.api.NetworkCall
import com.sample.aac.api.Resource
import com.sample.aac.data.model.BaseResponse
import com.sample.aac.data.model.UserResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(private val webservice: ApiService) {

    fun getUser(): LiveData<Resource<UserResponse>> {
        return NetworkCall<UserResponse>().makeCall(webservice.getUserData())
    }

    fun getError(): LiveData<Resource<BaseResponse>> {
        return NetworkCall<BaseResponse>().makeCall(webservice.getError())
    }
}