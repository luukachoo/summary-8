package com.example.summary8.domain.model

data class GetTour(
    val cover: String,
    val id: Int,
    val location: String,
    val price: String,
    val rate: Int?,
    val reactionCount: Int,
    val title: String
)