package com.razzdrawon.googlebookskotlin.di

import android.app.Application
import com.razzdrawon.googlebookskotlin.GoogleBooksApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = arrayOf(
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityBuilder::class))
interface AppComponent : AndroidInjector<GoogleBooksApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance fun application(application: Application): Builder
        fun build(): AppComponent
    }
}