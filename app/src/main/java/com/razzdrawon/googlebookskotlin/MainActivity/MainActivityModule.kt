package com.razzdrawon.googlebookskotlin.MainActivity

import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideMainActivityView(mainActivity: MainActivity): MainActivityView {
        return mainActivity
    }

    @Provides
    fun provideMainActivityPresenter(mainActivityView: MainActivityView): MainActivityPresenter {
        return MainActivityPresenter(mainActivityView)
    }
}