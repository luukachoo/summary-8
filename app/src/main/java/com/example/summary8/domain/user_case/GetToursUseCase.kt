package com.example.summary8.domain.user_case

import com.example.summary8.domain.repository.TourRepository
import javax.inject.Inject

class GetToursUseCase @Inject constructor(private val repository: TourRepository) {
    suspend operator fun invoke() =
        repository.getTours()
}