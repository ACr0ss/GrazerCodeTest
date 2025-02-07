package repository

import model.User


interface UserRepository {
    suspend fun fetchUsers(token: String): List<User>
}