package com.sample.aac.di.builder

import com.sample.aac.di.module.ViewModelModule
import com.sample.aac.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityBuilder {
//    @ContributesAndroidInjector(modules = [FragmentBuilder::class])
//    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun bindActivityMain(): MainActivity
}
