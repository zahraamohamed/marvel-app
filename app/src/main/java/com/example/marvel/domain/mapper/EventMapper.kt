package com.example.marvel.domain.mapper

import com.example.marvel.data.local.entity.EventEntity
import com.example.marvel.data.remote.response.EventDto
import com.example.marvel.domain.models.Character

class EventMapper : BaseMapper<EventDto, Character, EventEntity> {
    override fun mapToEntity(input: EventDto): EventEntity {
        val url = input.thumbnail?.path?.replace("http", "https")
        return EventEntity(
            id = input.id,
            name = input.title,
            imageUrl = "${url}.${input.thumbnail?.extension}",
            description = input.description
        )
    }

    override fun mapToCharacter(input: EventEntity): Character {
        return Character(
            id = input.id,
            name = input.name,
            imageUrl = input.imageUrl,
            description = input.description
        )
    }
}