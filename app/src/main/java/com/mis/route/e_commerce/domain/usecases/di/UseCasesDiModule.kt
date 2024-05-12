package com.mis.route.e_commerce.domain.usecases.di

import com.mis.route.e_commerce.data.repositories.auth.AuthRepositoryImpl
import com.mis.route.e_commerce.domain.repositories.auth.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCasesDiModule {

    @Binds
    abstract fun provideAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository
}