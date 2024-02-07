package com.example.summary8.presentation.screen.chat

import com.example.summary8.R
import com.example.summary8.databinding.FragmentChatBinding
import com.example.summary8.presentation.common.base.BaseFragment
import com.example.summary8.presentation.extension.showSnackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChatFragment : BaseFragment<FragmentChatBinding>(FragmentChatBinding::inflate) {
    override fun init() = with(binding) {
        tvWelcome.setOnClickListener {
            root.showSnackbar(getString(R.string.click_message))
        }
    }
}