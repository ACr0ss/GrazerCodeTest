package com.cross.grazercodetest.domain.usecase

import com.cross.grazercodetest.data.repository.UserRepository
import javax.inject.Inject

class FetchUsersUseCase @Inject constructor(private val repository: UserRepository) {
    suspend operator fun invoke(token: String) =
        repository.fetchUsers(token)
}