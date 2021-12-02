package com.example.marvel.data.remote.response


import com.google.gson.annotations.SerializedName

data class ComicsDto(
    @SerializedName("characters")
    val characters: SubList?,
    @SerializedName("comics")
    val comics: SubList?,
    @SerializedName("creators")
    val creators: SubList?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("end")
    val end: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("modified")
    val modified: String?,
    @SerializedName("next")
    val next: Item?,
    @SerializedName("previous")
    val previous: Item?,
    @SerializedName("resourceURI")
    val resourceURI: String?,
    @SerializedName("series")
    val series: SubList?,
    @SerializedName("start")
    val start: String?,
    @SerializedName("stories")
    val stories: SubList?,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("urls")
    val urls: List<Url>?
)