package com.example.marvel.domain

import com.example.marvel.data.remote.State
import com.example.marvel.domain.models.Character
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {
    fun getCharacters(): Flow<State<List<Character>?>>
    fun getCreator(): Flow<State<List<Character>?>>
    fun getSeries(): Flow<State<List<Character>?>>
    fun getComics(): Flow<State<List<Character>?>>
    fun getEvents(): Flow<State<List<Character>?>>
    fun getStories(): Flow<State<List<Character>?>>
    fun search(name: String): Flow<State<List<Character>?>>
    fun getCharacterById(id: Int): Flow<State<Character?>>
}