package com.example.marvel.domain.mapper

import com.example.marvel.domain.models.Character

interface Mapper<I, O,T> {
    fun mapToEntity(input: I): T
    fun  mapToCharacter(input: T): O
}