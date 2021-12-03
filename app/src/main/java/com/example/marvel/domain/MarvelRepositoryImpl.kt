package com.example.marvel.domain

import com.example.marvel.data.local.MarvelDatabase
import com.example.marvel.data.remote.MarvelService
import com.example.marvel.data.remote.State
import com.example.marvel.domain.mapper.MapperObject
import com.example.marvel.domain.models.Character
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MarvelRepositoryImpl @Inject constructor(
    private val apiService: MarvelService,
    private val mapperObject: MapperObject,
    private val marvelDatabase: MarvelDatabase,
) : MarvelRepository {

    override fun getCharacters(): Flow<State<List<Character>?>> {
        return flow {
            emit(State.Loading)
            try {
                val characters =
                    apiService.getCharacter().body()?.data?.results?.map { charactersDto ->
                        mapperObject.characterMapper.mapToEntity(charactersDto)
                    }
                val characterEntities = characters?.map { character ->
                    mapperObject.characterMapper.mapToCharacter(character)
                }

                characters?.let { marvelDatabase.characterDao.insertCharacters(it) }
                emit(State.Success(characterEntities))
            } catch (e: Exception) {
                emit(State.Error(e.message.toString()))
            }
        }
    }

    fun getAllCharacters(): Flow<List<Character>> {
        return marvelDatabase.characterDao
            .getCharacters().flatMapConcat {
                flow{
                    emit( it.map { mapperObject.characterMapper.mapToCharacter(it) } )
                }
            }
    }

    suspend fun refreshCharacters() {
        apiService.getCharacter().body()?.data?.results?.map {
            mapperObject.characterMapper.mapToEntity(it)
        }?.let {
            marvelDatabase.characterDao.insertCharacters(it)
        }
    }


    override fun getCreator(): Flow<State<List<Character>?>> {

        return flow {
            emit(State.Loading)
            try {
                val creator = apiService.getCreators().body()?.data?.results?.map { it ->
                    mapperObject.creatorMapper.mapToEntity(it)
                }
                val creatorEntities = creator?.map { character ->
                    mapperObject.creatorMapper.mapToCharacter(character)
                }
                creator?.let { marvelDatabase.creatorDao.insertCreator(it) }


                emit(State.Success(creatorEntities))
            } catch (e: Exception) {
                emit(State.Error(e.message.toString()))
            }
        }
    }

    override fun getSeries(): Flow<State<List<Character>?>> {
        return flow {
            emit(State.Loading)
            try {
                val series = apiService.getSeries().body()?.data?.results?.map { it ->
                    mapperObject.seriesMapper.mapToEntity(it)
                }
                val entities = series?.map { character ->
                    mapperObject.seriesMapper.mapToCharacter(character)

                }
                series?.let { marvelDatabase.seriesDao.insertSeries(it) }
                emit(State.Success(entities))
            } catch (e: Exception) {
                emit(State.Error(e.message.toString()))
            }
        }
    }





}

