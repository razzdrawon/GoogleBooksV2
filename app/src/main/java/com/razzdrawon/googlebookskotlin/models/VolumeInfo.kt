package com.razzdrawon.googlebookskotlin.models

import java.util.*

data class VolumeInfo (
    val title: String? = "",
    val publishedDate: String? = "",
    val description: String? = "",
    val imageLinks: ImageLink? = ImageLink(),
    val authors: List<String> = ArrayList()
){
    fun authorsString(): String {
        var authorsString = ""
        for (author in authors) {
            if (authorsString === "") {
                authorsString = author
            } else {
                authorsString = authorsString + "\n" + author
            }

        }
        return authorsString
    }
}
