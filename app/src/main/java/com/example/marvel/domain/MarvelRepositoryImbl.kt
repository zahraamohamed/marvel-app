package com.example.marvel.domain

import com.example.marvel.data.remote.State
import com.example.marvel.di.DependencyContainer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class MarvelRepositoryImbl:MarvelRepository {

    private val dependencyContainer = DependencyContainer()

    override fun getCharacters() = wrapWithFlow { dependencyContainer.apiService.getCharacter() }


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