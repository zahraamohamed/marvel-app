package com.example.marvel.domain.mapper

import com.example.marvel.data.remote.response.SeriesDto
import com.example.marvel.domain.models.Character

class SeriesMapper : MapToCharacter<SeriesDto, Character> {

    override fun mapToCharacter(input: SeriesDto): Character {
        val url = input.thumbnail?.path?.replace("http", "https")
        return Character(
            id = input.id,
            name = input.title,
            imageUrl = "${url}.${input.thumbnail?.extension}",
            description = input.description.toString()

        )
    }
}



