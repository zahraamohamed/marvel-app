package com.example.marvel.domain.mapper

import com.example.marvel.data.local.entity.CreatorEntity
import com.example.marvel.data.remote.response.CreatorDto
import com.example.marvel.domain.models.Character

class CreatorMapper : BaseMapper<CreatorDto, Character, CreatorEntity> {
    override fun mapToEntity(input: CreatorDto): CreatorEntity {
        val url = input.thumbnail?.path?.replace("http", "https")
        return CreatorEntity(
            id = input.id,
            name = input.fullName,
            imageUrl = "${url}.${input.thumbnail?.extension}",
            description = input.suffix
        )
    }

    override fun mapToCharacter(input: CreatorEntity): Character {
        return Character(
            id = input.id,
            name = input.name,
            imageUrl = input.imageUrl,
            description = input.description
        )
    }
}