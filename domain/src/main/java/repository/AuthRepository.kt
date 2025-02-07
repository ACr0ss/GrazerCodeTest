package repository

import model.LoginResponse

interface AuthRepository {
    suspend fun login(email: String, password: String): LoginResponse
}