package com.cross.grazercodetest.ui.userlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cross.grazercodetest.data.models.User
import com.cross.grazercodetest.data.models.UserResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.cross.grazercodetest.domain.usecase.FetchUsersUseCase
import com.cross.grazercodetest.utils.TokenManager
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val fetchUsersUseCase: FetchUsersUseCase,
    private val tokenManager: TokenManager
) : ViewModel() {

    private val _users = MutableStateFlow<List<User>?>(null)
    val users: StateFlow<List<User>?> = _users

    init {
        // Automatically fetch users when the ViewModel is initialized
        fetchUsers()
    }

    /**
     * Fetches the list of users from the API.
     */
    fun fetchUsers() {
        viewModelScope.launch {
            try {
                val token = tokenManager.getToken() ?: return@launch // Ensure a valid token exists
                val response = fetchUsersUseCase(token)
                if (response.status == 200) {
                    _users.value = response.data.users
                } else {
                    // Handle error cases (e.g., invalid token or server error)
                    _users.value = emptyList()
                }
            } catch (e: Exception) {
                // Handle network errors or other exceptions
                _users.value = emptyList()
            }
        }
    }
}