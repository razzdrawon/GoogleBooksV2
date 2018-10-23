package com.razzdrawon.googlebookskotlin.MainActivity

import com.razzdrawon.googlebookskotlin.models.Book

interface MainActivityView {
    fun showWait()
    fun removeWait()
    fun onAPIFailure()
    fun showToast(message: String)
    fun getBookResponseSuccess(books: ArrayList<Book>)
}