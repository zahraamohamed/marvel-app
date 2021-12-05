package com.example.marvel.ui.characterDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel.data.remote.State
import com.example.marvel.domain.MarvelRepository
import com.example.marvel.domain.models.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsCharacterViewModel @Inject constructor(
    private val repository: MarvelRepository,
) : ViewModel() {

    private val _characterDetails = MutableLiveData<State<Character?>>()
    val characterDetails: LiveData<State<Character?>> get() = _characterDetails

    fun onLoad(id: Int) {
        viewModelScope.launch {
            repository.getCharacterById(id).collect {
                _characterDetails.postValue(it) }
        }
    }
}
