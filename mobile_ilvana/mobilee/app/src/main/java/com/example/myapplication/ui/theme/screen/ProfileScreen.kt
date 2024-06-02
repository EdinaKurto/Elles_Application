package com.example.myapplication.ui.theme.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview

@SuppressLint("UnrememberedMutableState")
@Composable
fun ProfileScreen() {
    val textFieldShape = RoundedCornerShape(8.dp)

    var isEditing by remember { mutableStateOf(false) }
    var firstName by remember { mutableStateOf("Ilvana") }
    var lastName by remember { mutableStateOf("Burgic") }
    var email by remember { mutableStateOf("iburgic3@gmail.com") }

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
                value = firstName,
                onValueChange = { firstName = it },
                label = { Text("First Name") },
                shape = textFieldShape,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            OutlinedTextField(
                value = lastName,
                onValueChange = { lastName = it },
                label = { Text("Last Name") },
                shape = textFieldShape,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
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


            Button(
                onClick = { isEditing = false },
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
                    text = "Name: $firstName",
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = "Surname: $lastName",
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = "Email: $email",
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

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}
