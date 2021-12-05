package com.example.marvel.ui.home

import com.example.marvel.ui.base.BaseInteractionListener

interface HomeInteractionListener : BaseInteractionListener {
    fun onCharacterClicked(id: Int)
}