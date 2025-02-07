package model

data class UserResponse(
    val status: Int,
    val status_desc: String,
    val data: UserData
)

data class UserData(
    val users: List<User>,
    val meta: Meta
)

data class Meta(
    val item_count: Int,
    val total_pages: Int,
    val current_page: Int
)
