package com.example.marvel.ui

import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.marvel.R
import com.example.marvel.databinding.ActivityMainBinding
import com.example.marvel.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val viewID = R.layout.activity_main



    override fun onResume() {
        super.onResume()
        findNavController(R.id.nav_host_fragment).also { binding.navigationBottom.setupWithNavController(it) }
    }
}