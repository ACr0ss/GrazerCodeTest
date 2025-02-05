package com.cross.grazercodetest.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.cross.grazercodetest.domain.usecase.LoginUseCase
import com.cross.grazercodetest.utils.TokenManager
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val tokenManager: TokenManager
) : ViewModel() {
    private val _authToken = MutableStateFlow<String?>(null)
    val authToken: StateFlow<String?> = _authToken

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                val response = loginUseCase(email, password)
                if (response.status == 200) {
                    val token = response.auth.data.token
                    _authToken.value = token
                    tokenManager.saveToken(token)
                }
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}