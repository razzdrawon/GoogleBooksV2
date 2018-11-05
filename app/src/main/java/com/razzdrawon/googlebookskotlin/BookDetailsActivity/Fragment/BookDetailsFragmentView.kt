package com.razzdrawon.googlebookskotlin.BookDetailsActivity.Fragment

import com.razzdrawon.googlebookskotlin.models.Book

interface BookDetailsFragmentView {
    fun showWait()

    fun removeWait()

    fun onAPIFailure()

    fun getBookDetailsSuccess(book: Book)
}