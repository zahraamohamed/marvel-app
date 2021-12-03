package com.example.marvel.util

import com.example.marvel.data.remote.response.CharactersDto
import com.example.marvel.domain.models.Character


sealed class HomeItem(val number: Int) {
    class CharacterType(val items: List<Character>) : HomeItem(0)
    class ComicsType(val items: List<Character>) : HomeItem(1)
//    class SeriesType(val items: List<Character>) : HomeItem(2)

}