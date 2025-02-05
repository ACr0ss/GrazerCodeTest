package com.cross.grazercodetest.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TokenManager @Inject constructor(private val context: Context) {

    companion object {
        private const val TOKEN_KEY = "token"
        private const val DATASTORE_NAME = "app_datastore"
        val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = DATASTORE_NAME)
    }

    private val tokenKey = stringPreferencesKey(TOKEN_KEY)

    suspend fun saveToken(token: String) {
        context.dataStore.edit { settings ->
            settings[tokenKey] = token
        }
    }

    val tokenFlow: Flow<String?> = context.dataStore.data.map { preferences ->
        preferences[tokenKey]
    }

    suspend fun getToken(): String? {
        return context.dataStore.data.first()[tokenKey]
    }

    suspend fun clearToken() {
        context.dataStore.edit { settings ->
            settings.remove(tokenKey)
        }
    }
}
