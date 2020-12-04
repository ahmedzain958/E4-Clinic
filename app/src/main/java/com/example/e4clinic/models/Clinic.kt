package com.example.e4clinic.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
 data class Clinic(
    val doctorName: String,
    val visitTime: String,
    val address: String,
    val status: String
): Parcelable