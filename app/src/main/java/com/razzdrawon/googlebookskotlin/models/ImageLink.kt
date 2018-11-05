package com.razzdrawon.googlebookskotlin.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImageLink(
    val smallThumbnail: String? = "",
    val thumbnail: String = ""
) : Parcelable