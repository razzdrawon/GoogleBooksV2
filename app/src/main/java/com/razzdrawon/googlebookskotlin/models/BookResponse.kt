package com.razzdrawon.googlebookskotlin.models

data class BookResponse(
    val totalitems: Integer,
    val items: List<Book>
)