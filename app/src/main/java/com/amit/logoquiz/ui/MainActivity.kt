package com.amit.logoquiz.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.amit.logoquiz.databinding.ActivityMainBinding
import com.amit.logoquiz.viewModel.LogoViewModel
import com.bumptech.glide.RequestManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<LogoViewModel>()

    private lateinit var _binding : ActivityMainBinding

    @Inject
    lateinit var glide: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = _binding.root
        setContentView(view)
        observerState()
    }

    private fun observerState() {
        lifecycleScope.launch {
            viewModel.logoUiState.collect { it ->

                when (it) {
                    is LogoUIState.Loading -> {
                        // show loading state in page
                    }
                    is LogoUIState.PayLoad -> {

                    }
                }
            }
        }
    }
}