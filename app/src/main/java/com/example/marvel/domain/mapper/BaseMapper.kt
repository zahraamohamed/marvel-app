package com.example.marvel.domain.mapper

interface BaseMapper<I, O, T> {
    fun mapToEntity(input: I): T
    fun mapToCharacter(input: T): O
}