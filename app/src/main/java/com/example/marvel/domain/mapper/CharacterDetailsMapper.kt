package com.example.marvel.domain.mapper

import com.example.marvel.data.local.entity.CharacterDetailsEntity
import com.example.marvel.data.remote.response.CharactersDto
import com.example.marvel.domain.models.Character

class CharacterDetailsMapper : BaseMapper<CharactersDto, Character, CharacterDetailsEntity> {

     fun map(input: CharactersDto): Character {
        val url = input.thumbnail?.path?.replace("http", "https")
        return Character(
            id = input.id,
            name = input.name,
            imageUrl = "${url}.${input.thumbnail?.extension}",
            description = input.description,
        )
    }

    override fun mapToEntity(input: CharactersDto): CharacterDetailsEntity {
        val url = input.thumbnail?.path?.replace("http", "https")
        return CharacterDetailsEntity(
            id = input.id,
            name = input.name,
            imageUrl = "${url}.${input.thumbnail?.extension}",
            description = input.description,
        )
    }

    override fun mapToCharacter(input: CharacterDetailsEntity): Character {
        return Character(
            id = input.id,
            name = input.name,
            imageUrl = input.imageUrl,
            description = input.description
        )
    }
}