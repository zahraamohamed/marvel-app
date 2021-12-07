package com.example.marvel.domain.models

import com.example.marvel.data.remote.response.SubList

data class CharacterDetails(
    val id: Int?,
    val name: String?,
    val imageUrl: String?,
    val description: String?,
    val stories: SubList?,
)