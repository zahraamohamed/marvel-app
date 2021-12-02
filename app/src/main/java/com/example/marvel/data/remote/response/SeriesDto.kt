package com.example.marvel.data.remote.response


import com.google.gson.annotations.SerializedName

data class SeriesDto(
    @SerializedName("characters")
    val characters: SubList?,
    @SerializedName("comics")
    val comics: SubList?,
    @SerializedName("creators")
    val creators: SubList?,
    @SerializedName("description")
    val description: Any?,
    @SerializedName("endYear")
    val endYear: Int?,
    @SerializedName("events")
    val events: SubList?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("modified")
    val modified: String?,
    @SerializedName("next")
    val next: Item?,
    @SerializedName("previous")
    val previous: Item?,
    @SerializedName("rating")
    val rating: String?,
    @SerializedName("resourceURI")
    val resourceURI: String?,
    @SerializedName("startYear")
    val startYear: Int?,
    @SerializedName("stories")
    val stories: SubList?,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("urls")
    val urls: List<Url>?
)