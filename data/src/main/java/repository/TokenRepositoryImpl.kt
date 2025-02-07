package repository;

import datasource.TokenDataSource;
import jakarta.inject.Inject;
import kotlinx.coroutines.flow.Flow

class TokenRepositoryImpl @Inject
constructor(
        private val tokenDataSource:TokenDataSource
) : TokenRepository {
    override fun getTokenFlow(): Flow<String?> =
        tokenDataSource.getTokenFlow()

    override suspend fun saveToken(token: String) {
        tokenDataSource.saveToken(token)
    }

    override suspend fun clearToken() {
        tokenDataSource.clearToken()
    }
}