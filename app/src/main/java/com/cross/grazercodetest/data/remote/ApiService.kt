package com.cross.grazercodetest.data.remote

import com.cross.grazercodetest.data.models.AuthResponse
import com.cross.grazercodetest.data.models.UserResponse
import retrofit2.http.*

interface ApiService {
    companion object {
        private const val AUTH_ENDPOINT = "v1/auth/login"
        private const val USERS_ENDPOINT = "v1/users"
    }

    @POST(AUTH_ENDPOINT)
    suspend fun login(@Body credentials: Map<String, String>): AuthResponse

    @GET(USERS_ENDPOINT)
    suspend fun getUsers(@Header("Authorization") token: String): UserResponse
}
