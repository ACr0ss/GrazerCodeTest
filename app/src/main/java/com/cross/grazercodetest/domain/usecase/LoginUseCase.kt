package com.cross.grazercodetest.domain.usecase

import com.cross.grazercodetest.data.repository.UserRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: UserRepository) {
    suspend operator fun invoke(email: String, password: String) =
        repository.login(email, password)
}
