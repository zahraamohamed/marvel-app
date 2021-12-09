package com.example.marvel.domain.mapper

import com.example.marvel.data.remote.response.CharactersDto
import com.example.marvel.domain.models.Character

class CharacterDetailsMapper : MapToCharacter<CharactersDto, Character> {

    override fun mapToCharacter(input: CharactersDto): Character {

        val url = input.thumbnail?.path?.replace("http", "https")
        return Character(
            id = input.id,
            name = input.name,
            imageUrl = "${url}.${input.thumbnail?.extension}",
            description = input.description,
        )
    }
}