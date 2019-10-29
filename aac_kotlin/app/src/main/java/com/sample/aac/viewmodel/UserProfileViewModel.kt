package com.sample.aac.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sample.aac.api.Resource
import com.sample.aac.data.model.BaseResponse
import com.sample.aac.data.model.UserResponse
import com.sample.aac.repository.UserRepository
import javax.inject.Inject

class UserProfileViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    private val _userName = MutableLiveData<String>()
    private val _error = MutableLiveData<String>()
    private val _userResponse = MutableLiveData<UserResponse>()

    val user: LiveData<Resource<UserResponse>>
        get() = Transformations.switchMap(_userName) {
            userRepository.getUser()
        }

    val error: LiveData<Resource<BaseResponse>>
        get() = Transformations.switchMap(_error) {
            userRepository.getError()
        }

    val userResponse: LiveData<UserResponse> get() = _userResponse

    fun setUserResponse(userResponse: UserResponse) {
        _userResponse.postValue(userResponse)
    }

    fun getUser(userName: String) {
        _userName.postValue(userName)
    }

    fun getError() {
        _error.postValue("test")
    }
}