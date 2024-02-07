package com.example.summary8.presentation.screen.tour

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.summary8.databinding.FragmentTourBinding
import com.example.summary8.presentation.common.base.BaseFragment
import com.example.summary8.presentation.common.helper.Observer
import com.example.summary8.presentation.event.TourFragmentEvent
import com.example.summary8.presentation.extension.showSnackbar
import com.example.summary8.presentation.state.TourState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TourFragment : BaseFragment<FragmentTourBinding>(FragmentTourBinding::inflate), Observer {

    private val viewModel: TourViewModel by viewModels()
    private val viewPagerAdapter by lazy { TourViewPagerAdapter() }
    override fun init() {
        setUpViewPager()
        observers()

    }

    private fun setUpViewPager() = with(binding) {
        binding.viewPager.adapter = viewPagerAdapter
        viewModel.onEvent(TourFragmentEvent.FetchTours)
    }

    override fun observers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.recipeState.collect { x ->
                    handleTourState(x)
                }
            }
        }
    }

    private fun handleTourState(state: TourState) = with(binding) {
        binding.progressBar.isVisible = state.isLoading

        state.tours?.let {
            viewPagerAdapter.submitList(it)
        }

        state.errorMessage?.let {
            binding.root.showSnackbar(message = it)
            viewModel.onEvent(TourFragmentEvent.ResetErrorMessage)
        }
    }

}