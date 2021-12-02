package com.example.marvel.di

import com.example.marvel.data.local.MarvelDatabase
import com.example.marvel.data.remote.MarvelService
import com.example.marvel.domain.MarvelRepository
import com.example.marvel.domain.MarvelRepositoryImpl
import com.example.marvel.domain.mapper.CharacterMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        apiService: MarvelService,
        characterMapper: CharacterMapper,
     characterDatabase: MarvelDatabase
    ): MarvelRepository {
        return MarvelRepositoryImpl(apiService, characterMapper, characterDatabase)
    }

    @Singleton
    @Provides
    fun provideCharacterMapper(): CharacterMapper = CharacterMapper()

}