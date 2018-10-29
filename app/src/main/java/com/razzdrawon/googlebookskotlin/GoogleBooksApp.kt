package com.razzdrawon.googlebookskotlin

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import com.razzdrawon.googlebookskotlin.di.DaggerAppComponent

class GoogleBooksApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out GoogleBooksApp> {
        return DaggerAppComponent.builder().create(this);
    }
}