package com.example.marvel.ui.creator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.marvel.domain.MarvelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CreatorViewModel @Inject constructor(
    private val repository: MarvelRepository,

    ) : ViewModel(), CreatorsInteractionListener {

    val creator = repository.getCreator().asLiveData()

}