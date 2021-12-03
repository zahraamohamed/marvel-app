package com.example.marvel.ui.series

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.marvel.domain.MarvelRepository
import com.example.marvel.ui.home.HomeInteractionListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SeriesViewModel @Inject constructor(
    private val repository: MarvelRepository,

    ) : ViewModel(), SeriesInteractionListener {

    val series = repository.getSeries().asLiveData()

}
