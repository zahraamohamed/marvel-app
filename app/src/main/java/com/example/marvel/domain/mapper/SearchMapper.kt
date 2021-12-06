package com.example.marvel.domain.mapper

import com.example.marvel.data.local.entity.SearchEntity
import com.example.marvel.data.remote.response.CharactersDto
import com.example.marvel.domain.models.Character

class SearchMapper : Mapper<CharactersDto, Character, SearchEntity> {

    override fun mapToEntity(input: CharactersDto): SearchEntity {
        val url = input.thumbnail?.path?.replace("http", "https")

        return SearchEntity(
            id = input.id,
            name = input.name,
            imageUrl = "${url}.${input.thumbnail?.extension}",
            description = input.description,
        )
    }

    override fun mapToCharacter(input: SearchEntity): Character {
        return Character(
            id = input.id,
            name = input.name,
            imageUrl = input.imageUrl,
            description = input.description
        )
    }
}