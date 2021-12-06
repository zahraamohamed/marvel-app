package com.example.marvel.domain.mapper

import com.example.marvel.data.local.entity.CharacterEntity
import com.example.marvel.data.remote.response.CharactersDto
import com.example.marvel.domain.models.Character

class CharacterMapper:Mapper<CharactersDto, Character,CharacterEntity> {

    override fun mapToEntity(input: CharactersDto): CharacterEntity {
        val url = input.thumbnail?.path?.replace("http", "https")
        return CharacterEntity(
            id = input.id,
            name = input.name,
            imageUrl = "${url}.${input.thumbnail?.extension}",
            description = input.description,
        )
    }

   override fun mapToCharacter(input: CharacterEntity): Character {
        return Character(
            id = input.id,
            name = input.name,
            imageUrl = input.imageUrl,
            description = input.description
        )
    }
}