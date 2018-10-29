package com.razzdrawon.googlebookskotlin.MainActivity

import com.razzdrawon.googlebookskotlin.models.Book
import com.razzdrawon.googlebookskotlin.models.BookResponse
import com.razzdrawon.googlebookskotlin.services.GoogleBooksService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainActivityPresenter(
    val view: MainActivityView
) {

    private val retrofit by lazy {
        Retrofit.Builder()
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://www.googleapis.com/books/v1/")
            .build()
    }

    fun getBookList(){

        view.showWait()

        val service = retrofit.create(GoogleBooksService::class.java)

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