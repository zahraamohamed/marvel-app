package com.example.marvel.ui.series

import com.example.marvel.R
import com.example.marvel.data.remote.response.SeriesDto
import com.example.marvel.ui.base.BaseAdapter

class SeriesAdapter (
    items: List<SeriesDto>, listener: SeriesInteractionListener,
) : BaseAdapter<SeriesDto>(items, listener) {
    override val layoutID = R.layout.item_series
}