package com.cross.grazercodetest.data.repository

import com.cross.grazercodetest.data.models.AuthResponse
import com.cross.grazercodetest.data.models.UserResponse
import com.cross.grazercodetest.data.remote.ApiService
import javax.inject.Inject

class UserRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun login(email: String, password: String): AuthResponse =
        apiService.login(mapOf("email" to email, "password" to password))

    suspend fun fetchUsers(token: String): UserResponse =
        apiService.getUsers("Bearer $token")
}