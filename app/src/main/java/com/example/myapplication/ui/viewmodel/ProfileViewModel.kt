package com.example.myapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.myapplication.model.model.repositories.UserRepository
import com.example.myapplication.model.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProfileViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> get() = _user

    init {
        loadUserData()
    }

    private fun loadUserData() {
        viewModelScope.launch {
            val user = userRepository.getUser()
            _user.value = user
        }
    }

    fun updateUser(email: String, passwordHash: String) {
        viewModelScope.launch {
            val currentUser = _user.value
            if (currentUser != null) {
                val updatedUser = currentUser.copy(email = email, passwordHash = passwordHash)
                userRepository.updateUser(updatedUser)
                _user.value = updatedUser
            }
        }
    }
}
