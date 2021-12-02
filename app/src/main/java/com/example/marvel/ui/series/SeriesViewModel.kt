package com.example.marvel.ui.series

import androidx.lifecycle.ViewModel
import com.example.marvel.domain.MarvelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SeriesViewModel @Inject constructor(
    private val repository: MarvelRepository,

    ) : ViewModel(), SeriesInteractionListener {
}
