package com.razzdrawon.googlebookskotlin.BookDetailsActivity

import com.razzdrawon.googlebookskotlin.models.Book
import com.razzdrawon.googlebookskotlin.services.GoogleBooksService
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class BookDetailsActivityPresenter(private val view: BookDetailsActivityView, var service: GoogleBooksService) {

    fun getBookDetails(bookId: String) {
        view.showWait()

        service.getBookById(bookId)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Subscriber<Book>() {
                override fun onCompleted() {}

                override fun onError(e: Throwable) {
                    view.removeWait()
                    view.onAPIFailure()
                }

                override fun onNext(book: Book) {
                    view.removeWait()
                    view.getBookDetailsSuccess(book)
                }
            })
    }
}
