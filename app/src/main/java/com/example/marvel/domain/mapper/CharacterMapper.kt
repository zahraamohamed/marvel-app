package com.example.marvel.domain.mapper

import com.example.marvel.data.remote.response.CharactersDto
import com.example.marvel.domain.models.Character

class CharacterMapper:Mapper<CharactersDto,Character> {

    override fun map(input: CharactersDto): Character {
        return Character(
            id = input.id,
            name = input.name,
            imageUrl = "${input.thumbnail?.path}.${input.thumbnail?.extension}"
        )
    }
}