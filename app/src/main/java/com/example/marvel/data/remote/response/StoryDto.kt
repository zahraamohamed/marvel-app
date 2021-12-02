package com.example.marvel.data.remote.response


import com.google.gson.annotations.SerializedName

data class StoryDto(
    @SerializedName("characters")
    val characters: SubList?,
    @SerializedName("comics")
    val comics: SubList?,
    @SerializedName("creators")
    val creators: SubList?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("events")
    val events: SubList?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("modified")
    val modified: String?,
    @SerializedName("originalIssue")
    val originalIssue: Item?,
    @SerializedName("resourceURI")
    val resourceURI: String?,
    @SerializedName("series")
    val series: SubList?,
    @SerializedName("thumbnail")
    val thumbnail: Any?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("type")
    val type: String?
)