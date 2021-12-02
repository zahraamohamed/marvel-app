package com.example.marvel.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.marvel.domain.MarvelRepositoryImbl

class HomeViewModel:ViewModel(),CharacterInteractionListener {
    private val repository=MarvelRepositoryImbl()

    val characters=repository.getCharacters().asLiveData()

}