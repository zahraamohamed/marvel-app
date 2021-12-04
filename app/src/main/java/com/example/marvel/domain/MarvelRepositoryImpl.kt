package com.example.marvel.domain

import android.util.Log
import com.example.marvel.data.local.MarvelDatabase
import com.example.marvel.data.remote.MarvelService
import com.example.marvel.data.remote.State
import com.example.marvel.domain.mapper.AllMapper
import com.example.marvel.domain.models.Character
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MarvelRepositoryImpl @Inject constructor(
    private val apiService: MarvelService,
    private val mapperObject: AllMapper,
    private val marvelDatabase: MarvelDatabase,
) : MarvelRepository {

    override fun getCharacters() = wrapWithFlow(::getAllCharacters, ::refreshCharacters)
    override fun getCreator() = wrapWithFlow(::getAllCreators, ::refreshCreators)
    override fun getSeries() = wrapWithFlow(::getAllSeries, ::refreshSeries)
    override fun getComics() = wrapWithFlow(::getAllComics, ::refreshComics)
//    override fun search(name: String)=wrapWithFlow(::search,::refreshData )


    private suspend fun getAllCharacters(): List<Character> =
        marvelDatabase.characterDao.getCharacters().map {

            mapperObject.characterMapper.mapToCharacter(it)
        }

    private suspend fun refreshCharacters() {
        Log.v("hhhhhhhhhh", apiService.getCharacter().toString())

        apiService.getCharacter().body()?.data?.results?.map {

            mapperObject.characterMapper.mapToEntity(it)
        }?.let {
            marvelDatabase.characterDao.insertCharacters(it)

        }
    }

    private suspend fun getAllComics(): List<Character> =
        marvelDatabase.comicsDao.getComics().map {

            mapperObject.comicsMapper.mapToCharacter(it)
        }

    private suspend fun refreshComics() {
        apiService.getComics().body()?.data?.results?.map {

            mapperObject.comicsMapper.mapToEntity(it)
        }?.let {
            marvelDatabase.comicsDao.insertComics(it)

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

    private suspend fun search(): List<Character> = marvelDatabase.seriesDao.getSeries().map {
        mapperObject.seriesMapper.mapToCharacter(it)
    }

    private suspend fun refreshDataSearched() {
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
            Log.i("error hakeeer", e.message.toString())
        }
    }
}

