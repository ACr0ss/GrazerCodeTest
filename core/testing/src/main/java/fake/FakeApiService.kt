package fake

import api.ApiService
import model.AuthData
import model.AuthResponse
import model.Meta
import model.TokenData
import model.User
import model.UserData
import model.UserResponse

class FakeApiService : ApiService {
    override suspend fun login(credentials: Map<String, String>) = AuthResponse(
        status = 200,
        status_desc = "OK",
        auth = AuthData(
            data = TokenData(
                token = "fake_token"
            )
        )
    )

    override suspend fun getUsers(token: String) = UserResponse(
        status = 200,
        status_desc = "OK",
        data = UserData(
            users = listOf(
                User(
                    name = "John Doe",
                    date_of_birth = 978307200,
                    profile_image = "fake_url"
                )
            ),
            meta = Meta(
                item_count = 12,
                total_pages = 1,
                current_page = 1
            )
        )
    )
}