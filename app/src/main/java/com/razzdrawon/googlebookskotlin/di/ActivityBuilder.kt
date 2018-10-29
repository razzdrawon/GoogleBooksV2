package com.razzdrawon.googlebookskotlin.di

import com.razzdrawon.googlebookskotlin.MainActivity.MainActivity
import com.razzdrawon.googlebookskotlin.MainActivity.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector (modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity
}