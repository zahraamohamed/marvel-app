package com.example.marvel.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.marvel.databinding.FragmentSearchBinding
import com.example.marvel.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    override val viewModel: SearchViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentSearchBinding
        get() = FragmentSearchBinding::inflate


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchRecycler.adapter = SearchAdapter(emptyList(), viewModel)
        navigateFromFragment()
    }

    private fun navigateFromFragment() {
        viewModel.navigateToCharacterDetails.observe(this, { event ->
            event.getContentIfNotHandled()?.let {
                val action =
                    SearchFragmentDirections.actionSearchFragmentToDetailsCharacterFragment(it)
                findNavController().navigate(action)
            }
        }
        )
    }
}