package usecase

import kotlinx.coroutines.flow.Flow
import repository.TokenRepository
import javax.inject.Inject

class TokenUseCase @Inject constructor(
    private val tokenRepository: TokenRepository
) {
    fun getTokenFlow(): Flow<String?> =
        tokenRepository.getTokenFlow()

    suspend fun saveToken(token: String) {
        tokenRepository.saveToken(token)
    }

    suspend fun clearToken() {
        tokenRepository.clearToken()
    }
}