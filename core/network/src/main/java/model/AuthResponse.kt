package model

data class AuthResponse(
    val status: Int,
    val status_desc: String,
    val auth: AuthData
)

data class AuthData(
    val data: TokenData
)

data class TokenData(
    val token: String
)