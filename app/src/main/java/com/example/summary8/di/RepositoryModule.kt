package com.example.summary8.di

import com.example.summary8.data.remote.repository.TourRepositoryImpl
import com.example.summary8.domain.repository.TourRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    @Singleton
    fun bindToursRepository(repositoryImpl: TourRepositoryImpl): TourRepository
}