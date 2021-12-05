package com.example.marvel.ui.characterDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.example.marvel.databinding.FragmentDetailsCharacterBinding
import com.example.marvel.ui.base.BaseFragment


class DetailsCharacterFragment:BaseFragment<FragmentDetailsCharacterBinding>() {
    private val args: DetailsCharacterFragmentArgs by navArgs()

    override val viewModel: DetailsCharacterViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentDetailsCharacterBinding
    get() = FragmentDetailsCharacterBinding::inflate


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onLoad(args.id)

    }
}