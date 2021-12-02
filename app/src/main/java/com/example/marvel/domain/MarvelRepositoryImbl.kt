package com.example.marvel.domain

import com.example.marvel.data.local.MarvelDatabase
import com.example.marvel.data.local.entity.CharacterEntity
import com.example.marvel.data.remote.MarvelService
import com.example.marvel.data.remote.response.BaseResponse
import com.example.marvel.data.remote.response.CreatorDto
import com.example.marvel.domain.mapper.CharacterMapper
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MarvelRepositoryImbl @Inject constructor(
    private val apiService: MarvelService,
    private val characterMapper: CharacterMapper,
    private val characterDatabase: MarvelDatabase,
) : MarvelRepository {



    override fun getCharacters(): Flow<CharacterEntity> {
        return characterDatabase.characterDao.getCharacters()
    }



}