package com.cross.grazercodetest.presentation.userlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cross.grazercodetest.data.models.User
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
        initUsers()
    }

    fun initUsers() {
        viewModelScope.launch {
            try {
                val token = tokenManager.getToken() ?: return@launch
                val response = fetchUsersUseCase(token)
                if (response.status == 200) {
                    _users.value = response.data.users
                } else {
                    _users.value = emptyList()
                }
            } catch (e: Exception) {
                _users.value = emptyList()
            }
        }
    }
}