package com.razzdrawon.googlebookskotlin.models

data class Book(
    val id: String? = "",
    val volumeInfo: VolumeInfo? = VolumeInfo()
)