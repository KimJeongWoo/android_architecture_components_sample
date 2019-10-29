package com.sample.aac.ui

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.sample.aac.R
import com.sample.aac.api.Resource
import com.sample.aac.data.model.BaseResponse
import com.sample.aac.data.model.UserResponse
import com.sample.aac.databinding.ActivityMainBinding
import com.sample.aac.ui.base.BaseActivity
import com.sample.aac.util.AppLog
import com.sample.aac.viewmodel.UserProfileViewModel
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : BaseActivity() {

    lateinit var viewDataBinding: ActivityMainBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var userProfileViewModel: UserProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        AndroidInjection.inject(this)
        userProfileViewModel = ViewModelProviders.of(this, viewModelFactory)[UserProfileViewModel::class.java]
        userProfileViewModel.user.observe(this, Observer<Resource<UserResponse>> { response ->
            when (response.status) {
                Resource.Status.LOADING -> AppLog.i("LOADING")
                Resource.Status.SUCCESS -> {
                    response.data?.let {
                        AppLog.i("SUCCESS $it")
                        userProfileViewModel.setUserResponse(it)
                    }
                }
                Resource.Status.ERROR -> AppLog.i("ERROR ${response.message}")
            }
        })
        userProfileViewModel.userResponse.observe(this, Observer<UserResponse> {
            AppLog.i("userResponse.observe")

        })
        userProfileViewModel.error.observe(this, Observer<Resource<BaseResponse>> { response ->
            when (response.status) {
                Resource.Status.LOADING -> AppLog.i("LOADING")
                Resource.Status.SUCCESS -> AppLog.i("SUCCESS ${response.data}")
                Resource.Status.ERROR -> AppLog.i("ERROR ${response.message}")
            }
        })
        viewDataBinding.viewModel = userProfileViewModel
        viewDataBinding.lifecycleOwner = this

        button.setOnClickListener {
            userProfileViewModel.getUser("kim")
        }

        button2.setOnClickListener {
            userProfileViewModel.getError()
        }
    }
}