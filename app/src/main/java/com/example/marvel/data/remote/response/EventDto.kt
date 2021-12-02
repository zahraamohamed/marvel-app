package com.example.marvel.data.remote.response


import com.google.gson.annotations.SerializedName

data class EventDto(
    @SerializedName("characters")
    val characters: Item?,
    @SerializedName("comics")
    val comics: Item?,
    @SerializedName("creators")
    val creators: Item?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("end")
    val end: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("modified")
    val modified: String?,
    @SerializedName("next")
    val next: SubList?,
    @SerializedName("previous")
    val previous: SubList?,
    @SerializedName("resourceURI")
    val resourceURI: String?,
    @SerializedName("series")
    val series: Item?,
    @SerializedName("start")
    val start: String?,
    @SerializedName("stories")
    val stories: Item?,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("urls")
    val urls: List<Url>?
)