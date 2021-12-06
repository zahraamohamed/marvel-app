package com.example.marvel.ui.home

import androidx.lifecycle.*
import com.example.marvel.domain.MarvelRepository
import com.example.marvel.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MarvelRepository,

    ) : ViewModel(), HomeInteractionListener {

    val characters = repository.getCharacters().asLiveData()
    val creator = repository.getCreator().asLiveData()
    val comics = repository.getComics().asLiveData()


    private val _navigateToCharacterDetails = MutableLiveData<Event<Int>>()
    val navigateToCharacterDetails: LiveData<Event<Int>> get() = _navigateToCharacterDetails

    override fun onCharacterClicked(id: Int) {
        _navigateToCharacterDetails.value = Event(id)
    }


}