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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.ui.viewmodel.RegistrationState
import com.example.myapplication.ui.viewmodel.RegistrationViewModel

@Composable
fun RegistrationScreen(navController: NavController, registrationViewModel: RegistrationViewModel) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    val registrationState by registrationViewModel.registrationState.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text(
            text = "\n\nWelcome to Elles",
            color = Color(0xFF0066b2),
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(30.dp))
        TextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = password, onValueChange = { password = it }, label = { Text("Password") }, visualTransformation = PasswordVisualTransformation())
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = confirmPassword, onValueChange = { confirmPassword = it }, label = { Text("Confirm Password") }, visualTransformation = PasswordVisualTransformation())
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { registrationViewModel.register(email, password, confirmPassword) }) {
            Text("Register")
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text("Already have an account? Login here", modifier = Modifier.clickable {
            navController.navigate("login")
        })
    }

    when (registrationState) {
        is RegistrationState.Success -> {
            LaunchedEffect(Unit) {
                navController.navigate("home") {
                    popUpTo("registration") { inclusive = true }
                }
            }
        }
        is RegistrationState.Error -> {
            Text((registrationState as RegistrationState.Error).message)
        }
        else -> {}
    }
}