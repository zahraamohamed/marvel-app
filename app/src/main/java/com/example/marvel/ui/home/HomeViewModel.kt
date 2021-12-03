package com.example.marvel.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.marvel.domain.MarvelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MarvelRepository,

    ) : ViewModel(), HomeInteractionListener {

    val characters = repository.getCharacters().asLiveData()
    val series = repository.getSeries().asLiveData()
    val comics = repository.getSeries().asLiveData()




}