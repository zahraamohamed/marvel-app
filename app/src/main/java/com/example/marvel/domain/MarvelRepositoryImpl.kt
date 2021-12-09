package com.example.marvel.domain

import android.util.Log
import com.example.marvel.data.local.MarvelDatabase
import com.example.marvel.data.local.entity.SearchEntity
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


    override fun getCharacters() = wrap { getAllCharacters() }
    override fun getCreator() = wrap { getAllCreators() }
    override fun getComics() = wrap { getAllComics() }
    override fun getSeries() = wrap { getAllSeries() }
    override fun getEvents() = wrap { getAllEvent() }
    override fun getStories() = wrap { getAllStories() }
    override fun search(name: String): Flow<State<List<Character>?>> = wrap { getAllCharacterSearch(name) }
    override fun getCharacterById(id: Int) = wrap { getCharacterDetails(id)
    }

    private suspend fun refreshDataCharacters() {
        Log.v("hashish", apiService.getCharacter().toString())

        apiService.getCharacter().body()?.data?.results?.map {
            mapperObject.characterMapper.mapToEntity(it)
        }?.let {
            marvelDatabase.characterDao.insertCharacters(it)
        }
    }

    private suspend fun getAllCharacters(): List<Character> {
        refreshDataCharacters()
        return marvelDatabase.characterDao.getCharacters().map {
            mapperObject.characterMapper.mapToCharacter(it)
        }
    }


    private suspend fun refreshDataComics() {
        apiService.getComics().body()?.data?.results?.map {
            mapperObject.comicsMapper.mapToEntity(it)
        }?.let {
            marvelDatabase.comicsDao.insertComics(it)
        }
    }

    private suspend fun getAllComics(): List<Character> {
        refreshDataComics()
        return marvelDatabase.comicsDao.getComics().map {
            mapperObject.comicsMapper.mapToCharacter(it)
        }
    }

    private suspend fun refreshDataCreators() {
        apiService.getCreators().body()?.data?.results?.map {
            mapperObject.creatorMapper.mapToEntity(it)
        }?.let {
            marvelDatabase.creatorDao.insertCreator(it)
        }
    }

    private suspend fun getAllCreators(): List<Character> {
        refreshDataCreators()
        return marvelDatabase.creatorDao.getCreator().map {
            mapperObject.creatorMapper.mapToCharacter(it)
        }
    }

    private suspend fun refreshDataStories() {
        apiService.getStories().body()?.data?.results?.map {
            mapperObject.storiesMapper.mapToEntity(it)
        }?.let {
            marvelDatabase.storiesDao.insertStories(it)
        }
    }

    private suspend fun getAllStories(): List<Character> {
        refreshDataStories()
        return marvelDatabase.storiesDao.getStories().map {
            mapperObject.storiesMapper.mapToCharacter(it)
        }
    }


    private suspend fun getAllSeries() =
        apiService.getSeries().body()?.data?.results?.map {
            mapperObject.seriesMapper.mapToCharacter(it)

        }


    private suspend fun searchInDB(query: String): List<SearchEntity> =
        marvelDatabase.searchDao.searchInDB(query)

    private suspend fun getAllCharacterSearch(name: String): List<Character> {
        suspend fun result() = searchInDB("%$name%")
        if (result().isEmpty()) {
            refreshDataSearch(name)
        }
        return result().map {
            mapperObject.searchMapper.mapToCharacter(it)
        }
    }

    private suspend fun refreshDataSearch(name: String) {
        apiService.searchCharacter(name).body()?.data?.results?.map {
            mapperObject.searchMapper.mapToEntity(it)
        }?.let {
            marvelDatabase.searchDao.insert(it)
        }
    }

    private suspend fun getAllEvent() =
        apiService.getEvent().body()?.data?.results?.map {
            mapperObject.eventMapper.mapToCharacter(it)
        }


    private suspend fun getCharacterDetails(id: Int): Character? =
        (apiService.getCharacterById(id).body()?.data?.results?.first())
            ?.let { charactersDto ->
                mapperObject.characterDetailsMapper.mapToCharacter(charactersDto)
            }


    private fun <T> wrap(function: suspend () -> T): Flow<State<T?>> =
        flow {
            try {
                emit(State.Loading)
                emit(State.Success(function()))
            } catch (e: Exception) {
                emit(State.Error(e.message.toString()))
            }
        }
}

