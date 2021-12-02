package com.example.marvel.ui.home

import com.example.marvel.R
import com.example.marvel.data.remote.response.CharacterDto
import com.example.marvel.ui.base.BaseAdapter

class CharacterAdapter(
    items: List<CharacterDto>, listener: CharacterInteractionListener,
) : BaseAdapter<CharacterDto>(items, listener) {
    override val layoutID = R.layout.item_character
}