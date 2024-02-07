package com.example.summary8.data.remote.service

import com.example.summary8.data.remote.model.TourDto
import retrofit2.Response
import retrofit2.http.GET

interface TourService {
    @GET("0545ddc1-c487-46ce-b70c-5b95270d6b76")
    suspend fun getTours(): Response<List<TourDto>>
}