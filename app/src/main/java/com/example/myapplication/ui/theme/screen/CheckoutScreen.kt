package com.example.myapplication.ui.theme.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@SuppressLint("UnrememberedMutableState")
@Composable
fun CheckoutScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    val textFieldShape = RoundedCornerShape(8.dp)

    val firstName = remember { mutableStateOf("") }
    val lastName = remember { mutableStateOf("") }
    val address = remember { mutableStateOf("") }
    val number = remember { mutableStateOf("") }
    val cardNumber = remember { mutableStateOf("") }
    val nameOnCard = remember { mutableStateOf("") }
    val expirationDate = remember { mutableStateOf("") }
    val cvv = remember { mutableStateOf("") }

    val isButtonEnabled by derivedStateOf {
        firstName.value.isNotBlank() &&
                lastName.value.isNotBlank() &&
                address.value.isNotBlank() &&
                number.value.isNotBlank() &&
                cardNumber.value.isNotBlank() &&
                nameOnCard.value.isNotBlank() &&
                expirationDate.value.isNotBlank() &&
                cvv.value.isNotBlank()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp)
            .background(Color.White)
    ) {
        Text(
            text = "MY DETAILS",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = firstName.value,
            onValueChange = { firstName.value = it },
            label = { Text("First Name *") },
            shape = textFieldShape,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = lastName.value,
            onValueChange = { lastName.value = it },
            label = { Text("Last Name *") },
            shape = textFieldShape,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = address.value,
            onValueChange = { address.value = it },
            label = { Text("Address *") },
            shape = textFieldShape,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = number.value,
            onValueChange = { number.value = it },
            label = { Text("Number *") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone),
            shape = textFieldShape,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp)
        )

        Text(
            text = "PAYMENTS",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = cardNumber.value,
            onValueChange = { cardNumber.value = it },
            label = { Text("Card Number *") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            shape = textFieldShape,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = nameOnCard.value,
            onValueChange = { nameOnCard.value = it },
            label = { Text("Name on card *") },
            shape = textFieldShape,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = expirationDate.value,
            onValueChange = { expirationDate.value = it },
            label = { Text("Expiration date *") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            shape = textFieldShape,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = cvv.value,
            onValueChange = { cvv.value = it },
            label = { Text("CVV *") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            shape = textFieldShape,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp)
        )



        Button(
            onClick = {
                coroutineScope.launch {
                    snackbarHostState.showSnackbar("Success")
                    navController.navigate("home")
                }
            },
            colors = ButtonDefaults.buttonColors(Color(0xFF4CAF50)),
            enabled = isButtonEnabled,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(text = "BUY", color = Color.White, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        SnackbarHost(hostState = snackbarHostState)
    }
}
