package com.cross.grazercodetest.domain.usecase

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TokenUseCase @Inject constructor(private val dataStore: DataStore<Preferences>) {
    private val tokenKey = stringPreferencesKey("token")

    suspend fun saveToken(token: String) {
        dataStore.edit { preferences ->
            preferences[tokenKey] = token
        }
    }

    fun getTokenFlow(): Flow<String?> = dataStore.data.map { preferences ->
        preferences[tokenKey]
    }

    suspend fun getToken(): String? = dataStore.data.first()[tokenKey]

    suspend fun clearToken() {
        dataStore.edit { preferences ->
            preferences.remove(tokenKey)
        }
    }
}
