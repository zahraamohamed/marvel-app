package com.example.marvel.domain

import com.example.marvel.data.remote.State
import com.example.marvel.data.remote.response.CharactersDto
import com.example.marvel.domain.models.Character
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {
    fun getCharacters(): Flow<State<List<Character>?>>
    fun getCreator(): Flow<State<List<Character>?>>
    fun getSeries(): Flow<State<List<Character>?>>
    fun search(name:String): Flow<State<List<Character>?>>
}