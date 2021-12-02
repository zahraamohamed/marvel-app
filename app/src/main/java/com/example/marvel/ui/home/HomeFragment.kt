package com.example.marvel.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.marvel.databinding.FragmentHomeBinding
import com.example.marvel.domain.MarvelRepository
import com.example.marvel.domain.MarvelRepositoryImbl
import com.example.marvel.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val viewModel: HomeViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    @Inject
    lateinit var injectRepository: MarvelRepositoryImbl

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.scorerRecycler.adapter=CharacterAdapter(emptyList(),viewModel)
    }
}