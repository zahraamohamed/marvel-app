package com.example.marvel.domain

import com.example.marvel.data.local.entity.CharacterEntity
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {



     fun getCharacters(): Flow<CharacterEntity>
    suspend fun refreshCharacters()
}