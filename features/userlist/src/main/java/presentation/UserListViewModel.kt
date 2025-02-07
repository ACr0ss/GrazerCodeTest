package presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import model.User
import usecase.FetchUsersUseCase
import usecase.FormatDateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import usecase.TokenUseCase
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val fetchUsersUseCase: FetchUsersUseCase,
    private val tokenUseCase: TokenUseCase,
    private val formatDateUseCase: FormatDateUseCase
) : ViewModel() {
    private val _users = MutableStateFlow<List<User>?>(null)
    val users: StateFlow<List<User>?> = _users

    init {
        loadUsers()
    }

    private fun loadUsers() {
        viewModelScope.launch {
            tokenUseCase.getTokenFlow().collect { token ->
                if (token != null) {
                    try {
                        _users.value = fetchUsersUseCase(token)
                    } catch (e: Exception) {
                        _users.value = emptyList()
                    }
                }
            }
        }
    }

    fun formatDate(timestamp: Long): String = formatDateUseCase(timestamp)
}