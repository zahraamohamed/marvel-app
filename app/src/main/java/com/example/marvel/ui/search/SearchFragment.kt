package com.example.marvel.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.marvel.R
import com.example.marvel.databinding.FragmentSeriesBinding
import com.example.marvel.ui.base.BaseFragment
import com.example.marvel.ui.series.SeriesAdapter
import com.example.marvel.ui.series.SeriesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSeriesBinding>() {
    override val viewModel: SeriesViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentSeriesBinding
        get() = FragmentSeriesBinding::inflate


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}