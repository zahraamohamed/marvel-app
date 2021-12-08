package com.example.marvel.domain.mapper

import com.example.marvel.data.local.entity.StoriesEntity
import com.example.marvel.data.remote.response.StoriesDto
import com.example.marvel.domain.models.Character


class StoriesMapper : BaseMapper<StoriesDto, Character, StoriesEntity> {

    override fun mapToEntity(input: StoriesDto): StoriesEntity {
        val url = input.thumbnail?.path?.replace("http", "https")
        return StoriesEntity(
            id = input.id,
            name = input.title,
            imageUrl = "${url}.${input.thumbnail?.extension}",
            description = input.description
        )
    }

    override fun mapToCharacter(input: StoriesEntity): Character {
        return Character(
            id = input.id,
            name = input.name,
            imageUrl = input.imageUrl,
            description = input.description
        )
    }
}