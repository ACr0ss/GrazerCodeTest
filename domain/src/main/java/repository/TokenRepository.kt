package repository

import kotlinx.coroutines.flow.Flow

interface TokenRepository {
    fun getTokenFlow(): Flow<String?>
    suspend fun saveToken(token: String)
    suspend fun clearToken()
}
