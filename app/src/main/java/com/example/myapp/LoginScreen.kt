package com.example.myapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.ui.text.font.FontWeight

@Composable
fun LoginScreen(navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),  // Padding ekleyerek daha düzgün görünmesini sağladık
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo
        Image(
            painter = painterResource(id = R.drawable.mind),
            contentDescription = "App Logo",
            modifier = Modifier.size(200.dp)  // Logo boyutunu küçültme
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Başlık
        Text(
            text = "Welcome to MindUp",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(30.dp))

        // Email alanı
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email address") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()  // Genişlik ayarı
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Şifre alanı
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()  // Genişlik ayarı
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Login butonu
        Button(
            onClick = { navController.navigate("main") },
            modifier = Modifier.fillMaxWidth()  // Genişlik ayarı
        ) {
            Text("Login")
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Forgot Password linki
        Text(
            text = "Forgot Password?",
            modifier = Modifier.clickable { /* Handle forgot password */ },
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Google ile giriş yapma
        Text(text = "Or sign in with")

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(id = R.drawable.google),
                contentDescription = "Google Sign-In",
                modifier = Modifier
                    .size(30.dp)
                    .clickable { /* Handle Google Sign-In */ }
            )
        }
    }
}
