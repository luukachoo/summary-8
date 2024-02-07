package com.example.summary8.presentation.screen.tour

import android.util.Log.d
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.summary8.data.remote.util.Resource
import com.example.summary8.domain.user_case.GetToursUseCase
import com.example.summary8.presentation.event.TourFragmentEvent
import com.example.summary8.presentation.mapper.toPresentation
import com.example.summary8.presentation.state.TourState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TourViewModel @Inject constructor(private val getToursUseCase: GetToursUseCase) :
    ViewModel() {
    private val _tourState = MutableStateFlow(TourState())
    val recipeState = _tourState

    fun onEvent(event: TourFragmentEvent) {
        when (event) {
            is TourFragmentEvent.FetchTours -> fetchTours()
            is TourFragmentEvent.ResetErrorMessage -> updateErrorMessage(message = null)
        }
    }

    private fun fetchTours() {
        viewModelScope.launch {
            getToursUseCase().collect { resource ->
                _tourState.update { it.copy(isLoading = true) }
                when (resource) {
                    is Resource.Success -> {
                        _tourState.update { currentState ->
                            currentState.copy(
                                tours = resource.data.map { getTour ->
                                    getTour.toPresentation()
                                },
                                isLoading = false
                            )
                        }
                    }

                    is Resource.Error -> {
                        updateErrorMessage(resource.errorMessage)
                        d("RetrofitError", resource.errorMessage)
                    }
                }
            }
        }
    }


    private fun updateErrorMessage(message: String?) {
        _tourState.update { currentState -> currentState.copy(errorMessage = message) }
    }
}