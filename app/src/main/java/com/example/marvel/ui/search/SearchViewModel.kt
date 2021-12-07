package com.example.marvel.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.marvel.data.remote.State
import com.example.marvel.domain.MarvelRepository
import com.example.marvel.domain.models.Character
import com.example.marvel.ui.home.HomeInteractionListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.map
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: MarvelRepository,

    ) : ViewModel() ,HomeInteractionListener{

    var characterSearch: MutableStateFlow<String?> = MutableStateFlow("")


    var character = characterSearch.debounce(1500).map {
        searchForCharacter(it ?: "")
    }.asLiveData()


    private fun searchForCharacter(query: String): LiveData<State<List<Character>?>> =
        repository.search(query).asLiveData()


    override fun onCharacterClicked(id: Int) {

    }
}
