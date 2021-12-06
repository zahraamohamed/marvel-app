package com.example.marvel.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.marvel.databinding.FragmentHomeBinding
import com.example.marvel.ui.base.BaseFragment
import com.example.marvel.util.HomeItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val viewModel: HomeViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel.characters.observe(viewLifecycleOwner, {
//            Log.v("xyt", it.toData().toString())
//        })

        initNestedAdapter()
        observeListsForAdapter()
        navigateFromFragment()
    }

    private fun initNestedAdapter() {
        binding.nestedRecycler.adapter = HomeNestedRecyclerAdapter(mutableListOf(), viewModel)
    }

    private fun observeListsForAdapter() {
        (binding.nestedRecycler.adapter as HomeNestedRecyclerAdapter?)?.let { adapter ->

            viewModel.characters.observe(this@HomeFragment) { items ->
                items?.toData()?.let {
                    adapter.addItem(HomeItem.CharacterType(it))
                }
            }
            viewModel.comics.observe(this@HomeFragment) { items ->
                Log.v("xyt", items.toData().toString())

                items?.toData()?.let { adapter.addItem(HomeItem.ComicsType(it)) }
            }

            viewModel.creator.observe(this@HomeFragment) { items ->
                items?.toData()?.let { adapter.addItem(HomeItem.CreatorType(it)) }

            }
        }
    }

    private fun navigateFromFragment() {
        viewModel.navigateToCharacterDetails.observe(this, { event ->
            event.getContentIfNotHandled()?.let {
                val action = HomeFragmentDirections.actionHomeFragmentToDetailsCharacterFragment(it)
                findNavController().navigate(action)
            }
        }
        )
    }
}
