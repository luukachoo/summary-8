package com.example.summary8.data.remote.repository

import com.example.summary8.data.remote.mapper.asResource
import com.example.summary8.data.remote.mapper.toDomain
import com.example.summary8.data.remote.service.TourService
import com.example.summary8.data.remote.util.Resource
import com.example.summary8.data.remote.util.ResponseHandler
import com.example.summary8.domain.model.GetTour
import com.example.summary8.domain.repository.TourRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TourRepositoryImpl @Inject constructor(
    private val service: TourService,
    private val responseHandler: ResponseHandler
) : TourRepository {
    override suspend fun getTours(): Flow<Resource<List<GetTour>>> {
        return responseHandler.handleApiCall {
            service.getTours()
        }.asResource { list ->
            list.mapNotNull { it.toDomain() }
        }
    }
}