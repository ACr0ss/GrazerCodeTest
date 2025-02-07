package model

data class LoginResponse(
    val status: Int,
    val auth: Auth
) {
    data class Auth(
        val data: Data
    ) {
        data class Data(
            val token: String
        )
    }
}