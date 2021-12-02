package com.example.marvel.data.remote.response


import com.google.gson.annotations.SerializedName

data class DataContainer <T>(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("limit")
    val limit: Int?,
    @SerializedName("offset")
    val offset: Int?,
    @SerializedName("results")
    val results: List<T>?,
    @SerializedName("total")
    val total: Int?
)