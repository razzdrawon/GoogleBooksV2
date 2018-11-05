package com.razzdrawon.googlebookskotlin.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Book(
    val id: String? = "",
    val volumeInfo: VolumeInfo? = VolumeInfo()
) : Parcelable