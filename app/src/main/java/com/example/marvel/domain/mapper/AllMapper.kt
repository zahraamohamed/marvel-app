package com.example.marvel.domain.mapper


data class AllMapper(
    val characterMapper: CharacterMapper,
    val creatorMapper: CreatorMapper,
    val seriesMapper: SeriesMapper,
    val comicsMapper: ComicsMapper,
    val eventMapper: EventMapper,
    val storiesMapper: StoriesMapper,
    val searchMapper: SearchMapper,
)