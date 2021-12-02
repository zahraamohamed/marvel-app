package com.example.marvel.domain

import android.util.Log
import com.example.marvel.data.local.MarvelDatabase
import com.example.marvel.data.remote.MarvelService
import com.example.marvel.data.remote.State
import com.example.marvel.domain.mapper.CharacterMapper
import com.example.marvel.domain.mapper.CreatorMapper
import com.example.marvel.domain.mapper.MapperObject
import com.example.marvel.domain.models.Character
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class MarvelRepositoryImpl @Inject constructor(
    private val apiService: MarvelService,
    private val mapperObject: MapperObject,
    private val characterDatabase: MarvelDatabase,
) : MarvelRepository {

    override fun getCharacters(): Flow<State<List<Character>?>> {
        return flow {
            emit(State.Loading)
            try {
                val characters = apiService.getCharacter().body()?.data?.results?.map { charactersDto ->
                    mapperObject.characterMapper.map(charactersDto)
                }
                val characterEntities = characters?.map { character ->
                    mapperObject.characterMapper.mapToEntity(character)
                }

                characterEntities?.let{characterDatabase.characterDao.insertCharacters(it)}
                Log.v("TESTING", characterEntities.toString())
                emit(State.Success(characters))
            } catch (e: Exception) {
                emit(State.Error(e.message.toString()))
            }
        }
    }

    override fun getCreator(): Flow<State<List<Character>?>> {

        return flow {
            emit(State.Loading)
            try {
                val creator = apiService.getCreators().body()?.data?.results?.map { it ->
                    mapperObject.creatorMapper.map(it)
                }
                emit(State.Success(creator))
            } catch (e: Exception) {
                emit(State.Error(e.message.toString()))
            }
        }
    }


//     fun<T> wrapWithFlow(function: suspend () -> Response<T>): Flow<State<List<Character>?>>
//    = flow {
//            emit(State.Loading)
//            try {
//                val response = function().body()?.data?.results?.map { dto ->
//                    characterMapper.map(dto)
//                }
//                emit(State.Success(response))
//            } catch (e: Exception) {
//                emit(State.Error(e.message.toString()))
//            }
//        }
//    }

    private fun <T> wrapWithFlow(function: suspend () -> Response<T>): Flow<State<T?>> =
        flow {
            try {
                emit(State.Loading)
                emit(checkIsSuccessful(function()))
            } catch (e: Exception) {
                emit(State.Error(e.message.toString()))
            }
        }

    private fun <T> checkIsSuccessful(response: Response<T>): State<T?> =
        if (response.isSuccessful) {
            State.Success(response.body())
        } else {
            State.Error(response.message())
        }
}
