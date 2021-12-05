package com.example.marvel.domain.mapper

import com.example.marvel.data.local.entity.SeriesEntity
import com.example.marvel.data.remote.response.SeriesDto
import com.example.marvel.domain.models.Character

class SeriesMapper : BaseMapper<SeriesDto, Character, SeriesEntity> {
    override fun mapToEntity(input: SeriesDto): SeriesEntity {
        val url = input.thumbnail?.path?.replace("http", "https")
        return SeriesEntity(
            id = input.id,
            name = input.title,
            imageUrl = "${url}.${input.thumbnail?.extension}",
            description = input.description.toString()

        )
    }

    override fun mapToCharacter(input: SeriesEntity): Character {
        return Character(
            id = input.id,
            name = input.name,
            imageUrl = input.imageUrl,
            description = input.description
        )
    }
}



