package com.example.myapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.model.repositories.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import android.util.Log

sealed class LoginState {
    object Idle : LoginState()
    data class Success(val user: com.example.myapplication.model.model.User) : LoginState()
    data class Error(val message: String) : LoginState()
}

class LoginViewModel(private val userRepository: UserRepository) : ViewModel() {
    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState: StateFlow<LoginState> = _loginState

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                val user = userRepository.getUserByEmail(email).first()
                if (user != null && user.passwordHash == password) {
                    _loginState.value = LoginState.Success(user)
                    Log.d("LoginViewModel", "User logged in successfully: $user")
                } else {
                    _loginState.value = LoginState.Error("Invalid credentials")
                }
            } catch (e: Exception) {
                _loginState.value = LoginState.Error("An error occurred: ${e.message}")
            }
        }
    }
}
