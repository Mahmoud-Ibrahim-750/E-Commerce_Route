package com.mis.route.e_commerce.data.repositories.di

import com.mis.route.e_commerce.data.repositories.auth.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoriesImplDiModule {

    // TODO: Ask MN: why can't hilt provide this object like the use case object?
    // TODO: Ask MN: about the convention in DI and naming classes and packages
    @Provides
    fun provideAuthRepositoryImpl(): AuthRepositoryImpl = AuthRepositoryImpl()
}