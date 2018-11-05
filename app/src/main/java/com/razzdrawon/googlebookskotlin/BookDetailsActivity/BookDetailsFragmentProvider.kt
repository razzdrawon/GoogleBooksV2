package com.razzdrawon.googlebookskotlin.BookDetailsActivity

import com.razzdrawon.googlebookskotlin.BookDetailsActivity.Fragment.BookDetailsFragment
import com.razzdrawon.googlebookskotlin.BookDetailsActivity.Fragment.BookDetailsFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BookDetailsFragmentProvider {
    @ContributesAndroidInjector(modules = arrayOf(BookDetailsFragmentModule::class))
    internal abstract fun provideBookDetailsFragmentFactory(): BookDetailsFragment
}