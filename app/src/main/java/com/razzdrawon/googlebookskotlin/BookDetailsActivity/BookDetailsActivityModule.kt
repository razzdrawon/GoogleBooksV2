package com.razzdrawon.googlebookskotlin.BookDetailsActivity

import com.razzdrawon.googlebookskotlin.services.GoogleBooksService
import dagger.Module
import dagger.Provides

@Module
class BookDetailsActivityModule {

    @Provides
    internal fun provideBookDetailsActivityView(bookDetailsActivity: BookDetailsActivity): BookDetailsActivityView {
        return bookDetailsActivity
    }

    @Provides
    internal fun provideBookDetailsPresenter(
        bookDetailsView: BookDetailsActivityView,
        googleBooksService: GoogleBooksService
    ): BookDetailsActivityPresenter {
        return BookDetailsActivityPresenter(bookDetailsView, googleBooksService)
    }
}
