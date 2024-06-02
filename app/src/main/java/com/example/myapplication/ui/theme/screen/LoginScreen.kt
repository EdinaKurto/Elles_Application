package com.example.myapplication.ui.theme.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Typeface
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.ui.viewmodel.LoginState
import com.example.myapplication.ui.viewmodel.LoginViewModel

@Composable
fun LoginScreen(navController: NavController, loginViewModel: LoginViewModel) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val loginState by loginViewModel.loginState.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text(
            text = "\n\nWelcome back to Elles",
            color = Color(0xFF0066b2),
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(30.dp))
        TextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = password, onValueChange = { password = it }, label = { Text("Password") }, visualTransformation = PasswordVisualTransformation())
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { loginViewModel.login(email, password) }) {
            Text("Login")
        }
        Spacer(modifier = Modifier.height(50.dp))
        Text("Don't have an account? Register here", modifier = Modifier.clickable {
            navController.navigate("registration")
        })
    }

    when (loginState) {
        is LoginState.Success -> {
            LaunchedEffect(Unit) {
                navController.navigate("home") {
                    popUpTo("login") { inclusive = true }
                }
            }
        }
        is LoginState.Error -> {
            Text((loginState as LoginState.Error).message)
        }
        else -> {}
    }
}