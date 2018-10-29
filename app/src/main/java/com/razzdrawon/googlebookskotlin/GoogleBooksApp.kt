package com.razzdrawon.googlebookskotlin

import com.razzdrawon.googlebookskotlin.di.AppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class GoogleBooksApp : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {
        val component: AppComponent = DaggerAppComponent
            .builder()
            .application(this)
            .build()
        return component
    }

}
