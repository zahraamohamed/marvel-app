package com.example.marvel.ui.home

import com.example.marvel.R
import com.example.marvel.domain.models.Character
import com.example.marvel.ui.base.BaseAdapter

class ComicsAdapter(
    items: List<Character>, listener: HomeInteractionListener,
) : BaseAdapter<Character>(items, listener) {
    override val layoutID = R.layout.item_comices
}