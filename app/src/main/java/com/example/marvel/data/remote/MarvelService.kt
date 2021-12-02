package com.example.marvel.data.remote

import com.example.marvel.data.remote.response.BaseResponse
import com.example.marvel.data.remote.response.CharacterDto
import retrofit2.Response
import retrofit2.http.GET

interface MarvelService {

    @GET("characters")
    suspend fun getCharacter(): Response<BaseResponse<CharacterDto>?>
}