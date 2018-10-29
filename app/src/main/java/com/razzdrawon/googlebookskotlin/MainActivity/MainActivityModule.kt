package com.razzdrawon.googlebookskotlin.MainActivity

import com.razzdrawon.googlebookskotlin.services.GoogleBooksService
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideMainActivityView(mainActivity: MainActivity): MainActivityView {
        return mainActivity
    }

    @Provides
    fun provideMainActivityPresenter(mainActivityView: MainActivityView, googleBooksService: GoogleBooksService): MainActivityPresenter {
        return MainActivityPresenter(mainActivityView, googleBooksService)
    }
}