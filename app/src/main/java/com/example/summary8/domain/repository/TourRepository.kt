package com.example.summary8.domain.repository

import com.example.summary8.data.remote.util.Resource
import com.example.summary8.domain.model.GetTour
import kotlinx.coroutines.flow.Flow

interface TourRepository {
    suspend fun getTours(): Flow<Resource<List<GetTour>>>
}