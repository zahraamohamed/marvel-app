package com.example.marvel.data.remote.response


import com.google.gson.annotations.SerializedName

data class SubList(
    @SerializedName("available")
    val available: Int?,
    @SerializedName("collectionURI")
    val collectionURI: String?,
    @SerializedName("items")
    val items: List<Item>?,
    @SerializedName("returned")
    val returned: Int?
)