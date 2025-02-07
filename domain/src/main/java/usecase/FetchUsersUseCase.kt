package usecase

import model.User
import repository.UserRepository
import javax.inject.Inject

class FetchUsersUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(token: String): List<User> {
        return userRepository.fetchUsers(token)
    }
}