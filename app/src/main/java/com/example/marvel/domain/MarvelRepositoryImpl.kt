package com.example.marvel.domain

import com.example.marvel.data.local.MarvelDatabase
import com.example.marvel.data.local.entity.CharacterEntity
import com.example.marvel.data.remote.MarvelService
import com.example.marvel.data.remote.State
import com.example.marvel.data.remote.response.BaseResponse
import com.example.marvel.data.remote.response.CreatorDto
import com.example.marvel.domain.mapper.CharacterMapper
import com.example.marvel.domain.models.Character
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class MarvelRepositoryImpl @Inject constructor(
    private val apiService: MarvelService,
    private val characterMapper: CharacterMapper,
    private val characterDatabase: MarvelDatabase,
) : MarvelRepository {

    override fun getCharacters(): Flow<State<List<Character>?>> {
        return flow {
            emit(State.Loading)
            try {
                val characters = apiService.getCharacter().body()?.data?.results?.map { charactersDto ->
                    characterMapper.map(charactersDto)
                }
                emit(State.Success(characters))
            } catch (e: Exception) {
                emit(State.Error(e.message.toString()))
            }
        }
    }

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
