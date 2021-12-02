package com.example.marvel.ui.home

import com.example.marvel.R
import com.example.marvel.data.remote.response.CharactersDto
import com.example.marvel.ui.base.BaseAdapter

class CharacterAdapter(
    items: List<CharactersDto>, listener: CharacterInteractionListener,
) : BaseAdapter<CharactersDto>(items, listener) {
    override val layoutID = R.layout.item_character
}