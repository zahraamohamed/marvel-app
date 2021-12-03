package com.example.marvel.domain.mapper

import javax.inject.Inject


data class AllMapper (
    val characterMapper: CharacterMapper,
    val creatorMapper: CreatorMapper,
    val seriesMapper: SeriesMapper,
)