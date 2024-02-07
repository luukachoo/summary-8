package com.example.summary8.presentation.model

data class Tour(
    val cover: String,
    val id: Int,
    val location: String,
    val price: String,
    val rate: Int?,
    val reactionCount: Int,
    val title: String
)