package com.razzdrawon.googlebookskotlin.models

import java.util.*

data class VolumeInfo (
    val title: String? = "",
    val publishedDate: String? = "",
    val description: String? = "",
    val imageLink: ImageLink? = ImageLink(),
    val authors: List<String>? = ArrayList()
)
