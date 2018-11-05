package com.razzdrawon.googlebookskotlin.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BookResponse(
    val totalitems: Integer,
    val items: List<Book>
) : Parcelable