package com.example.marvel.di

import com.example.marvel.data.local.MarvelDatabase
import com.example.marvel.data.remote.MarvelService
import com.example.marvel.domain.MarvelRepository
import com.example.marvel.domain.MarvelRepositoryImpl
import com.example.marvel.domain.mapper.CharacterMapper
import com.example.marvel.domain.mapper.CreatorMapper
import com.example.marvel.domain.mapper.MapperObject
import com.example.marvel.domain.mapper.SeriesMapper
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
        mapperObject: MapperObject,
        marvelDatabase: MarvelDatabase,
    ): MarvelRepository {
        return MarvelRepositoryImpl(apiService, mapperObject, marvelDatabase)
    }

    @Singleton
    @Provides
    fun provideMapperObjectMapper(
        characterMapper: CharacterMapper,
        creatorMapper: CreatorMapper,
        seriesMapper: SeriesMapper,
    ): MapperObject = MapperObject(characterMapper, creatorMapper,seriesMapper)

    @Singleton
    @Provides
    fun provideCharacterMapper(): CharacterMapper = CharacterMapper()

    @Singleton
    @Provides
    fun provideCreatorMapper(): CreatorMapper = CreatorMapper()

    @Singleton
    @Provides
    fun provideSeriesMapper(): SeriesMapper = SeriesMapper()

}