package com.example.summary8.presentation.event

sealed class TourFragmentEvent {
    data object FetchTours : TourFragmentEvent()
    data object ResetErrorMessage : TourFragmentEvent()
}