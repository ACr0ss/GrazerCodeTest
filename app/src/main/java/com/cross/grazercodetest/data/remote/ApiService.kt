package com.cross.grazercodetest.data.remote

import com.cross.grazercodetest.data.models.AuthResponse
import com.cross.grazercodetest.data.models.UserResponse
import com.cross.grazercodetest.utils.Constants.AUTH_ENDPOINT
import com.cross.grazercodetest.utils.Constants.USERS_ENDPOINT
import retrofit2.http.*

interface ApiService {
    @POST(AUTH_ENDPOINT)
    suspend fun login(@Body credentials: Map<String, String>): AuthResponse

    @GET(USERS_ENDPOINT)
    suspend fun getUsers(@Header("Authorization") token: String): UserResponse
}