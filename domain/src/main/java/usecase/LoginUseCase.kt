package usecase

import model.LoginResponse
import repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(email: String, password: String): LoginResponse {
        return authRepository.login(email, password)
    }
}