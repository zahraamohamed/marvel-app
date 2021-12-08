package com.example.marvel.domain.mapper

import com.example.marvel.data.local.entity.ComicsEntity
import com.example.marvel.data.remote.response.ComicsDto
import com.example.marvel.domain.models.Character

class ComicsMapper : BaseMapper<ComicsDto, Character, ComicsEntity> {

    override fun mapToEntity(input: ComicsDto): ComicsEntity {
        val url = input.thumbnail?.path?.replace("http", "https")
        return ComicsEntity(
            id = input.id,
            name = input.title,
            imageUrl = "${url}.${input.thumbnail?.extension}",
            description = input.description,
        )
    }

    override fun mapToCharacter(input: ComicsEntity): Character {
        return Character(
            id = input.id,
            name = input.name,
            imageUrl = input.imageUrl,
            description = input.description
        )
    }
}