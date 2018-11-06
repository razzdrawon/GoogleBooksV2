package com.razzdrawon.googlebookskotlin.BookDetailsActivity

import com.razzdrawon.googlebookskotlin.models.Book

interface BookDetailsActivityView {
    fun showWait()

    fun removeWait()

    fun onAPIFailure()

    fun getBookDetailsSuccess(book: Book)
}