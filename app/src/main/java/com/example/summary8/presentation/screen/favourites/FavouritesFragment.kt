package com.example.summary8.presentation.screen.favourites

import com.example.summary8.R
import com.example.summary8.databinding.FragmentFavouritesBinding
import com.example.summary8.presentation.common.base.BaseFragment
import com.example.summary8.presentation.extension.showSnackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavouritesFragment :
    BaseFragment<FragmentFavouritesBinding>(FragmentFavouritesBinding::inflate) {
    override fun init() = with(binding) {
        tvWelcome.setOnClickListener {
            root.showSnackbar(getString(R.string.click_message))
        }
    }
}