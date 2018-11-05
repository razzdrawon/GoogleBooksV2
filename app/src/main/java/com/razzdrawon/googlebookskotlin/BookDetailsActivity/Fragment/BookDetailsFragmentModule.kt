package com.razzdrawon.googlebookskotlin.BookDetailsActivity.Fragment

import com.razzdrawon.googlebookskotlin.services.GoogleBooksService
import dagger.Module
import dagger.Provides

@Module
class BookDetailsFragmentModule {

    @Provides
    internal fun provideBookDetailsFragmentView(bookDetailFragment: BookDetailsFragment): BookDetailsFragmentView {
        return bookDetailFragment
    }

    @Provides
    internal fun provideBookDetailsFragmentPresenter(
        bookDetailsView: BookDetailsFragmentView,
        googleBooksService: GoogleBooksService
    ): BookDetailsFragmentPresenter {
        return BookDetailsFragmentPresenter(bookDetailsView, googleBooksService)
    }

}