package com.example.marvel.data.remote

import com.example.marvel.data.remote.response.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelService {

    @GET("characters")
    suspend fun getCharacter(): Response<BaseResponse<CharactersDto>?>

    @GET("characters")
    suspend fun searchCharacter(
        @Query("name", encoded = false) name: String,
    ): Response<BaseResponse<CharactersDto>?>


    @GET("characters/{characterId}")
    suspend fun getCharacterById(
        @Path("characterId") characterId: Int,
    ): Response<BaseResponse<CharactersDto>?>

    @GET("comics")
    suspend fun getComics(
    ): Response<BaseResponse<ComicsDto>?>

    @GET("creators")
    suspend fun getCreators(
    ): Response<BaseResponse<CreatorDto>?>

    @GET("stories")
    suspend fun getStories(
    ): Response<BaseResponse<StoriesDto>?>

    @GET("series")
    suspend fun getSeries(
    ): Response<BaseResponse<SeriesDto>?>

    @GET("events")
    suspend fun getEvent(
    ): Response<BaseResponse<EventDto>?>
}