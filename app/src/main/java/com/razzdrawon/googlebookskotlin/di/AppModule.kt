package com.razzdrawon.googlebookskotlin.di

import android.app.Application
import com.razzdrawon.googlebookskotlin.GoogleBooksApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideContext(application: Application): GoogleBooksApp {
        return application as GoogleBooksApp
    }
}
