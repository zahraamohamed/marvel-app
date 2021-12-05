package com.example.marvel.di

import com.example.marvel.data.local.MarvelDatabase
import com.example.marvel.data.remote.MarvelService
import com.example.marvel.domain.MarvelRepository
import com.example.marvel.domain.MarvelRepositoryImpl
import com.example.marvel.domain.mapper.*
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
        mapperObject: AllMapper,
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
        comicsMapper: ComicsMapper,
        eventMapper: EventMapper,
        storiesMapper: StoriesMapper,
        searchMapper: SearchMapper,
    ): AllMapper = AllMapper(characterMapper,
        creatorMapper,
        seriesMapper,
        comicsMapper,
        eventMapper,
        storiesMapper,
        searchMapper)

    @Singleton
    @Provides
    fun provideCharacterMapper(): CharacterMapper = CharacterMapper()

    @Singleton
    @Provides
    fun provideCreatorMapper(): CreatorMapper = CreatorMapper()

    @Singleton
    @Provides
    fun provideSeriesMapper(): SeriesMapper = SeriesMapper()

    @Singleton
    @Provides
    fun provideComicsMapper(): ComicsMapper = ComicsMapper()

    @Singleton
    @Provides
    fun provideEventMapper(): EventMapper = EventMapper()

    @Singleton
    @Provides
    fun provideStoriesMapper(): StoriesMapper = StoriesMapper()

    @Singleton
    @Provides
    fun provideSearchMapper(): SearchMapper = SearchMapper()

}