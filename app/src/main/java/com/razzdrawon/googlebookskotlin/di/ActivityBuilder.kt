package com.razzdrawon.googlebookskotlin.di

import com.razzdrawon.googlebookskotlin.MainActivity.MainActivity
import com.razzdrawon.googlebookskotlin.MainActivity.MainActivityModule
import com.razzdrawon.googlebookskotlin.services.NetworkModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector (modules = arrayOf(MainActivityModule::class, NetworkModule::class))
    abstract fun bindMainActivity(): MainActivity
}