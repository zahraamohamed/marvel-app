package com.example.marvel.ui.creator

import androidx.lifecycle.ViewModel
import com.example.marvel.domain.MarvelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CreatorViewModel @Inject constructor(
    private val repository: MarvelRepository,

    ) : ViewModel(), CreatorsInteractionListener {

}