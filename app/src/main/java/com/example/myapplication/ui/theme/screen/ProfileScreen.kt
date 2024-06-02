package com.example.myapplication.ui.theme.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.navigation.NavHostController
import com.example.myapplication.ui.viewmodel.ProfileViewModel

@SuppressLint("UnrememberedMutableState")
@Composable
fun ProfileScreen(navController: NavHostController, profileViewModel: ProfileViewModel) {
    val user by profileViewModel.user.collectAsState()

    val textFieldShape = RoundedCornerShape(8.dp)

    var isEditing by remember { mutableStateOf(false) }
    var email by remember { mutableStateOf(user?.email ?: "") }
    var password by remember { mutableStateOf(user?.passwordHash ?: "") }
    var isPasswordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(color = Color.White)
    ) {
        if (isEditing) {
            Text(
                text = "PROFILE",
                fontSize = 24.sp,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                shape = textFieldShape,
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                shape = textFieldShape,
                visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            Button(
                onClick = {
                    isEditing = false
                    profileViewModel.updateUser(email, password)
                },
                colors = ButtonDefaults.buttonColors(Color(0xFF2196F3)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Save Changes", color = Color.White, fontSize = 16.sp)
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Email: ${user?.email}",
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = "Password: ${user?.passwordHash}",
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Button(
                    onClick = { isEditing = true },
                    colors = ButtonDefaults.buttonColors(Color(0xFF2196F3)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text = "Edit", color = Color.White, fontSize = 16.sp)
                }
            }
        }
    }
}
