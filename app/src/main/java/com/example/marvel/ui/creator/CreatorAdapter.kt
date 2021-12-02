package com.example.marvel.ui.creator

import com.example.marvel.R
import com.example.marvel.data.remote.response.CreatorDto
import com.example.marvel.ui.base.BaseAdapter
import com.example.marvel.ui.home.CharacterInteractionListener

class CreatorAdapter(
    items: List<CreatorDto>, listener: CreatorsInteractionListener,
) : BaseAdapter<CreatorDto>(items, listener) {
    override val layoutID = R.layout.item_creator
}