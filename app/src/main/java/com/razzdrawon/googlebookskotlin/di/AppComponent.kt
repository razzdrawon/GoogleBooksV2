package com.razzdrawon.googlebookskotlin.di

import com.razzdrawon.googlebookskotlin.GoogleBooksApp
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = arrayOf(AndroidSupportInjectionModule::class, AppModule::class, ActivityBuilder::class))
interface AppComponent : AndroidInjector<GoogleBooksApp>{
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<GoogleBooksApp>()
}