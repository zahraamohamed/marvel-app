package com.example.marvel.ui.event

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.marvel.databinding.FragmentEventBinding
import com.example.marvel.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EventFragment : BaseFragment<FragmentEventBinding>() {
    override val viewModel: EventViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentEventBinding
        get() = FragmentEventBinding::inflate


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.eventRecycler.adapter = EventAdapter(emptyList(), viewModel)

    }
}