package com.example.marvel.domain

import com.example.marvel.data.remote.State
import com.example.marvel.data.remote.response.BaseResponse
import com.example.marvel.data.remote.response.CharacterDto
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {
    fun getCharacters(): Flow<State<BaseResponse<CharacterDto>?>>
}