package api

import model.AuthResponse
import model.UserResponse
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    companion object {
        private const val AUTH_ENDPOINT = "v1/auth/login"
        private const val USERS_ENDPOINT = "v1/users"
    }

    @POST(AUTH_ENDPOINT)
    suspend fun login(credentials: Map<String, String>): AuthResponse

    @GET(USERS_ENDPOINT)
    suspend fun getUsers(token: String): UserResponse
}