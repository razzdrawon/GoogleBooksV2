package com.razzdrawon.googlebookskotlin.services

import com.razzdrawon.googlebookskotlin.models.Book
import com.razzdrawon.googlebookskotlin.models.BookResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable

interface GoogleBooksService {

    @GET("volumes")
    fun getBooks(
        @Query("q") query: String,
        @Query("startIndex") startIndex: Int,
        @Query("maxResults") maxResults: Int) : Observable<BookResponse>

    @GET("volumes/{volumeId}")
    fun getBookById(@Path("volumeId") volumeId: String) : Observable<Book>
}