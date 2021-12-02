package com.example.marvel.domain.mapper

import com.example.marvel.data.local.entity.CharacterEntity
import com.example.marvel.data.remote.response.CharactersDto
import com.example.marvel.domain.models.Character

class CharacterMapper:Mapper<CharactersDto, Character> {
    override fun map(input: CharactersDto): Character {
        val url = input.thumbnail?.path?.replace("http", "https")
        return Character(
            id = input.id,
            name = input.name,
            imageUrl = "${url}.${input.thumbnail?.extension}"
        )
    }

    fun mapToEntity(input: Character): CharacterEntity {
        return CharacterEntity(
            id = input.id,
            name = input.name,
            imageUrl = input.imageUrl,
            description = null
        )
    }
}