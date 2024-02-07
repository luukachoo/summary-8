package com.example.summary8.data.remote.model

import com.squareup.moshi.Json

data class TourDto(
    @Json(name = "cover")
    val cover: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "location")
    val location: String,
    @Json(name = "price")
    val price: String,
    @Json(name = "rate")
    val rate: Int?,
    @Json(name = "reaction_count")
    val reactionCount: Int,
    @Json(name = "title")
    val title: String
)