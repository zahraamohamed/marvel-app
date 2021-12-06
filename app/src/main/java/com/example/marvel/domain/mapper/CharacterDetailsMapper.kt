package com.example.marvel.domain.mapper

import com.example.marvel.data.remote.response.CharactersDto
import com.example.marvel.domain.models.Character
import com.example.marvel.domain.models.CharacterDetails

class CharacterDetailsMapper : MapToCharacter<CharactersDto, CharacterDetails> {

    override fun mapToCharacter(input: CharactersDto): CharacterDetails {

        val url = input.thumbnail?.path?.replace("http", "https")
        return CharacterDetails(
            id = input.id,
            name = input.name,
            imageUrl = "${url}.${input.thumbnail?.extension}",
            description = input.description,
            stories = input.stories,
        )
    }
}