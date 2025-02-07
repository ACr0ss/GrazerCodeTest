package repository

import api.ApiService
import datasource.TokenDataSource
import model.LoginResponse
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val tokenDataSource: TokenDataSource
) : AuthRepository {
    override suspend fun login(email: String, password: String): LoginResponse {
        val networkResponse = apiService.login(mapOf(
            "email" to email,
            "password" to password
        ))
        tokenDataSource.saveToken(networkResponse.auth.data.token)

        return LoginResponse(
            status = networkResponse.status,
            auth = LoginResponse.Auth(
                data = LoginResponse.Auth.Data(
                    token = networkResponse.auth.data.token
                )
            )
        )
    }
}