package com.example.marvel.domain.mapper

import com.example.marvel.data.remote.response.EventDto
import com.example.marvel.domain.models.Character

class EventMapper : MapToCharacter<EventDto, Character> {

    override fun mapToCharacter(input: EventDto): Character {
        val url = input.thumbnail?.path?.replace("http", "https")
        return Character(
            id = input.id,
            name = input.title,
            imageUrl = "${url}.${input.thumbnail?.extension}",
            description = input.description
        )
    }
}