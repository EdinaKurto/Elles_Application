package com.example.myapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.model.User
import com.example.myapplication.model.model.repositories.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import android.util.Log
import kotlinx.coroutines.flow.first

sealed class RegistrationState {
    object Idle : RegistrationState()
    data class Success(val user: User) : RegistrationState()
    data class Error(val message: String) : RegistrationState()
}

class RegistrationViewModel(private val userRepository: UserRepository) : ViewModel() {
    private val _registrationState = MutableStateFlow<RegistrationState>(RegistrationState.Idle)
    val registrationState: StateFlow<RegistrationState> = _registrationState

    fun register(email: String, password: String, confirmPassword: String) {
        if (password != confirmPassword) {
            _registrationState.value = RegistrationState.Error("Passwords do not match")
            return
        }

        viewModelScope.launch {
            try {
                val existingUser = userRepository.getUserByEmail(email).first()
                if (existingUser != null) {
                    _registrationState.value = RegistrationState.Error("User already exists")
                } else {
                    val user = User(id = java.util.UUID.randomUUID().toString(), email = email, passwordHash = password)
                    userRepository.insertUser(user)
                    _registrationState.value = RegistrationState.Success(user)
                    Log.d("RegistrationViewModel", "User registered successfully: $user")
                }
            } catch (e: Exception) {
                _registrationState.value = RegistrationState.Error("An error occurred: ${e.message}")
            }
        }
    }
}
