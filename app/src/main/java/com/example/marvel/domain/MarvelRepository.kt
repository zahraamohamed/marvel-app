package com.example.marvel.domain

import com.example.marvel.data.local.entity.CharacterEntity
import com.example.marvel.data.remote.State
import com.example.marvel.data.remote.response.BaseResponse
import com.example.marvel.data.remote.response.CreatorDto
import com.example.marvel.domain.models.Character
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {
    fun getCharacters(): Flow<State<List<Character>?>>
}