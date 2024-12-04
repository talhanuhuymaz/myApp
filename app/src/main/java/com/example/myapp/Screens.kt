package com.example.myapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SignUp(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TextField(
            value = "",
            label = { Text("Username") },
            onValueChange = {},
            leadingIcon = { Icon(Icons.Default.Face,
                contentDescription = "") }

        )
        OutlinedTextField(
            value="",
            label = { Text("Email") },
            onValueChange = {},
            leadingIcon = { Icon(Icons.Default.Email,
                contentDescription = "") }
        )
        Button(onClick = {}) {
            Row (verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Sign Up")
            }
        }

    }
}

@Composable
fun MyMainScreen(){


}

@Preview(showSystemUi = true)
@Composable
fun SignUpPreview(){
    MaterialTheme {
        Surface {
            SignUp()
        }
    }
}