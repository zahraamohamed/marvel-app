package com.example.marvel.ui.series

import com.example.marvel.R
import com.example.marvel.data.remote.response.SeriesDto
import com.example.marvel.domain.models.Character
import com.example.marvel.ui.base.BaseAdapter
import com.example.marvel.ui.home.HomeInteractionListener

class SeriesAdapter (
    items: List<Character>, listener: SeriesInteractionListener,
) : BaseAdapter<Character>(items, listener) {
    override val layoutID = R.layout.item_series
}