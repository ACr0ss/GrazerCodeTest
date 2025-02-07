package fake

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeTokenDataSource {
    private var token: String? = "fake_preview_token"

    fun getTokenFlow(): Flow<String?> = flow { emit(token) }

    suspend fun saveToken(newToken: String) {
        token = newToken
    }

    suspend fun clearToken() {
        token = null
    }
}