package com.example.summary8.presentation.mapper

import com.example.summary8.domain.model.GetTour
import com.example.summary8.presentation.model.Tour

fun GetTour.toPresentation() = Tour(
    cover = cover,
    id = id,
    location = location,
    price = price,
    rate = rate,
    reactionCount = reactionCount,
    title = title
)