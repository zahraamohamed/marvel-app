package com.example.marvel.ui.search

import com.example.marvel.R
import com.example.marvel.ui.base.BaseAdapter
import com.example.marvel.ui.home.HomeInteractionListener

class SearchAdapter ( items: List<Character>, listener: HomeInteractionListener,
) : BaseAdapter<Character>(items, listener) {
    override val layoutID = R.layout.item_search
}