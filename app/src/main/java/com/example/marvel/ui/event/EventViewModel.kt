package com.example.marvel.ui.event

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.marvel.domain.MarvelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class EventViewModel @Inject constructor(
    private val repository: MarvelRepository,

    ) : ViewModel(), EventInteractionListener {

    val event = repository.getEvents().asLiveData()

}