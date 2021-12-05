package com.example.marvel.ui.event

import com.example.marvel.R
import com.example.marvel.data.remote.response.CreatorDto
import com.example.marvel.domain.models.Character
import com.example.marvel.ui.base.BaseAdapter

class EventAdapter(
    items: List<Character>, listener: EventInteractionListener,
) : BaseAdapter<Character>(items, listener) {
    override val layoutID = R.layout.item_event
}