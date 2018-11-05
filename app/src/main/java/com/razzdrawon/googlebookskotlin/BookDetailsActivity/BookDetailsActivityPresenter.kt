package com.razzdrawon.googlebookskotlin.BookDetailsActivity

import com.razzdrawon.googlebookskotlin.models.Book
import com.razzdrawon.googlebookskotlin.services.GoogleBooksService
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class BookDetailsActivityPresenter(private val view: BookDetailsActivityView, var service: GoogleBooksService) {

    fun showMessage() {
        view.showLoaded("BookDetailsActivityPresenter Loaded")
    }
}
