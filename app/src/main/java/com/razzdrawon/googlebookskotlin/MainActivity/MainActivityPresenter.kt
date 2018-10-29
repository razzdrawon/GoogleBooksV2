package com.razzdrawon.googlebookskotlin.MainActivity

import com.razzdrawon.googlebookskotlin.models.Book
import com.razzdrawon.googlebookskotlin.models.BookResponse
import com.razzdrawon.googlebookskotlin.services.GoogleBooksService
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainActivityPresenter(
    val view: MainActivityView,
    val service: GoogleBooksService
) {

    fun getBookList(){

        view.showWait()

        service.getBooks("android", 0, 10)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { bookResponse: BookResponse? ->
                    view.removeWait()
                    view.getBookResponseSuccess((bookResponse?.items as ArrayList<Book>))
                },
                {error ->
                    view.removeWait()
                    view.showToast(error.message.toString())
                    view.onAPIFailure()
                }
            )

    }


}