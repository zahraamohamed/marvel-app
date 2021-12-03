package com.example.marvel.data.remote

import com.example.marvel.data.remote.response.*
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelService {

    @GET("characters")
    suspend fun getCharacter(): Response<BaseResponse<CharactersDto>?>

   @GET("characters")
     fun searchCharacter(
       @Query("name") name: String
   ):Response<BaseResponse<CharactersDto>?>


    @GET("characters/{characterId}")
    suspend fun getCharacterById(
        @Path("characterID") characterId: Int,
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
}