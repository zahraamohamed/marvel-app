package com.example.marvel.ui.main

import android.net.Uri
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.marvel.R
import com.example.marvel.databinding.ActivityMainBinding
import com.example.marvel.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val theme = R.style.Theme_Marvel
    override val viewID = R.layout.activity_main



    override fun onResume() {
        super.onResume()
        findNavController(R.id.nav_host_fragment).also { binding.navigationBottom.setupWithNavController(it) }
    }
}