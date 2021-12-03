package com.example.marvel.ui.creator

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.marvel.databinding.FragmentCreatorBinding
import com.example.marvel.ui.base.BaseFragment
import com.example.marvel.ui.home.CharacterAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreatorFragment : BaseFragment<FragmentCreatorBinding>() {
    override val viewModel: CreatorViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentCreatorBinding
        get() = FragmentCreatorBinding::inflate


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.creator.observe(this,{
            Log.v("testt",it.toString())
        })
        binding.creatorRecycler.adapter = CreatorAdapter(emptyList(), viewModel)

    }
}