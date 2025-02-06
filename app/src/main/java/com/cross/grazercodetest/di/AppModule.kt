package com.cross.grazercodetest.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.cross.grazercodetest.data.remote.ApiClient
import com.cross.grazercodetest.domain.usecase.TokenUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideTokenUseCase(dataStore: DataStore<Preferences>): TokenUseCase =
        TokenUseCase(dataStore)

    @Singleton
    @Provides
    fun provideApiService(): ApiClient =
        ApiClient
}
