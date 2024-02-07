package com.example.summary8.data.remote.mapper

import com.example.summary8.data.remote.model.TourDto
import com.example.summary8.domain.model.GetTour

fun TourDto.toDomain() =
    GetTour(
        cover = cover,
        id = id,
        location = location,
        price = price,
        rate = rate,
        reactionCount = reactionCount,
        title = title
    )
