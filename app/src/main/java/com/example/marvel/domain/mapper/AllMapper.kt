package com.example.marvel.domain.mapper


data class AllMapper(
    val characterMapper: CharacterMapper,
    val creatorMapper: CreatorMapper,
    val seriesMapper: SeriesMapper,
    val comicsMapper: ComicsMapper,
)