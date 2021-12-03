package com.example.marvel.ui.search

import androidx.lifecycle.ViewModel
import com.example.marvel.domain.MarvelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: MarvelRepository,

    ) : ViewModel() {
}
