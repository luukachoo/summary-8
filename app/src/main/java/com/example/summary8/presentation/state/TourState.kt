package com.example.summary8.presentation.state

import com.example.summary8.presentation.model.Tour

data class TourState(
    val tours: List<Tour>? = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)