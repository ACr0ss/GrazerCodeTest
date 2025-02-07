package repository

import api.ApiService
import model.User
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : UserRepository {
    override suspend fun fetchUsers(token: String): List<User> {
        val response = apiService.getUsers("Bearer $token")
        return response.data.users.map { networkUser ->
            User(
                name = networkUser.name,
                dateOfBirth = networkUser.dateOfBirth,
                profileImage = networkUser.profileImage
            )
        }
    }
}