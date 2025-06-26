package com.example.te.api

import android.graphics.pdf.PdfDocument.Page
import com.google.gson.annotations.SerializedName


data class Person(
    var id: Long?,
    var email: String?,
    @SerializedName("first_name")
    var firstName: String?,
    @SerializedName("last_name")
    var lastName: String?,
    var avatar: String?
)

data class RegResObj <T> (
    var page: Int?,
    @SerializedName("per_page")
    var perPage: Int?,
    var total: Int?,
    @SerializedName("total_page")
    var totalPages: Int?,
    var data: T?
)