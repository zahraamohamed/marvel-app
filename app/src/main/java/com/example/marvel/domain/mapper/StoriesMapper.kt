package com.example.marvel.domain.mapper

import com.example.marvel.data.local.entity.StoriesEntity
import com.example.marvel.data.remote.response.StoriesDto
import com.example.marvel.domain.models.Character


class StoriesMapper : MapToCharacter<StoriesDto, Character> {

    override fun mapToCharacter(input: StoriesDto): Character {
        val url = input.thumbnail?.path?.replace("http", "https")
        return Character(
            id = input.id,
            name = input.title,
            imageUrl = "${url}.${input.thumbnail?.extension}",
            description = input.description
        )    }
}