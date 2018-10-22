package com.razzdrawon.googlebookskotlin.MainActivity

import com.razzdrawon.googlebookskotlin.models.Book
import com.razzdrawon.googlebookskotlin.models.ImageLink
import com.razzdrawon.googlebookskotlin.models.VolumeInfo

class MainActivityPresenter(
    val view: MainActivityView
) {
    fun getBookList(){
        var books = ArrayList<Book>()
        books.add(Book(id = "KER0dd2oYP8C", volumeInfo = VolumeInfo(title = "Embedded Android", imageLink = ImageLink(smallThumbnail = "http://books.google.com/books/content?id=KER0dd2oYP8C&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api"))))
        books.add(Book(id = "vhWMAgAAQBAJ", volumeInfo = VolumeInfo(title = "Learning Android", imageLink = ImageLink(smallThumbnail = "http://books.google.com/books/content?id=vhWMAgAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api"))))
        books.add(Book(id = "KER0dd2oYP8C", volumeInfo = VolumeInfo(title = "Book 3")))
        books.add(Book(id = "KER0dd2oYP8C", volumeInfo = VolumeInfo(title = "Book 4")))
        books.add(Book(id = "KER0dd2oYP8C", volumeInfo = VolumeInfo(title = "Book 5")))
        view.getBookResponseSuccess(books)
    }
}