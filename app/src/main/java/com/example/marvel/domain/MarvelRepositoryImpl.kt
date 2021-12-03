package com.example.marvel.domain

import com.example.marvel.data.local.MarvelDatabase
import com.example.marvel.data.remote.MarvelService
import com.example.marvel.data.remote.State
import com.example.marvel.domain.mapper.MapperObject
import com.example.marvel.domain.models.Character
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MarvelRepositoryImpl @Inject constructor(
    private val apiService: MarvelService,
    private val mapperObject: MapperObject,
    private val marvelDatabase: MarvelDatabase,
) : MarvelRepository {

    override fun getCharacters() = wrapWithFlow(::getAllCharacters, ::refreshCharacters)
    override fun getCreator() = wrapWithFlow(::getAllCreators, ::refreshCreators)
    override fun getSeries() = wrapWithFlow(::getAllSeries, ::refreshSeries)


    private suspend fun getAllCharacters(): List<Character> =
        marvelDatabase.characterDao.getCharacters().map {
            mapperObject.characterMapper.mapToCharacter(it)
        }

    private suspend fun refreshCharacters() {
        apiService.getCharacter().body()?.data?.results?.map {
            mapperObject.characterMapper.mapToEntity(it)
        }?.let {
            marvelDatabase.characterDao.insertCharacters(it)
        }
    }

    private suspend fun getAllCreators(): List<Character> =
        marvelDatabase.creatorDao.getCreator().map {
            mapperObject.creatorMapper.mapToCharacter(it)
        }

    private suspend fun refreshCreators() {
        apiService.getCreators().body()?.data?.results?.map {
            mapperObject.creatorMapper.mapToEntity(it)
        }?.let {
            marvelDatabase.creatorDao.insertCreator(it)
        }
    }

    private suspend fun getAllSeries(): List<Character> = marvelDatabase.seriesDao.getSeries().map {
        mapperObject.seriesMapper.mapToCharacter(it)
    }

    private suspend fun refreshSeries() {
        apiService.getSeries().body()?.data?.results?.map {
            mapperObject.seriesMapper.mapToEntity(it)
        }?.let {
            marvelDatabase.seriesDao.insertSeries(it)
        }
    }


    private fun <T> wrapWithFlow(
        getData: suspend () -> List<T>,
        refreshData: suspend () -> Unit,
    ): Flow<State<List<T>>> = flow {
        emit(State.Loading)
        try {

            emit(State.Success(getData()))
            refreshData()

        } catch (e: Exception) {
        }
    }


}

