package com.cross.grazercodetest.data.models;

data class UserResponse(
        val status: Int,
        val status_desc: String,
        val data: UserData
)

data class UserData(
        val users: List<User>,
        val meta: Meta
)

data class User(
        val name: String,
        val date_of_birth: Long,
        val profile_image: String
)

data class Meta(
        val item_count: Int,
        val total_pages: Int,
        val current_page: Int
)