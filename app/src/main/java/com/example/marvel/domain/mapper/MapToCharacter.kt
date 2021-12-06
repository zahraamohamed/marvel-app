package com.example.marvel.domain.mapper

interface MapToCharacter<T,O> {
    fun mapToCharacter(input: T): O
}