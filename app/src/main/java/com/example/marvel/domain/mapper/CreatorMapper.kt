package com.example.marvel.domain.mapper

import com.example.marvel.data.remote.response.CreatorDto
import com.example.marvel.domain.models.Character

class CreatorMapper:Mapper<CreatorDto, Character> {
    override fun map(input: CreatorDto): Character {
        val url = input.thumbnail?.path?.replace("http", "https")
        return Character(
            id = input.id,
            name = input.fullName,
            imageUrl = "${url}.${input.thumbnail?.extension}"
        )
    }
}