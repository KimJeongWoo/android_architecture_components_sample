package com.sample.aac.ui.base

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("Registered")

//abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {
//    lateinit var viewDataBinding: T
//    abstract val layoutResourceId: Int
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        viewDataBinding = DataBindingUtil.setContentView(this, layoutResourceId)
//    }
//}

open class BaseActivity : AppCompatActivity()

//open class BaseActivity : AppCompatActivity() {
//    @Inject
//    lateinit var viewModelFactory: ViewModelProvider.Factory
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        AndroidInjection.inject(this)
//    }
//}
