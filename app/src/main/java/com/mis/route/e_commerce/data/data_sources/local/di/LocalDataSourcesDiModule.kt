package com.mis.route.e_commerce.data.data_sources.local.di

import android.content.Context
import android.content.SharedPreferences
import com.mis.route.e_commerce.data.DataConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object LocalDataSourcesDiModule {

    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(
            DataConstants.SHARED_PREFERENCES_FILE_PATH,
            Context.MODE_PRIVATE
        )
    }
}