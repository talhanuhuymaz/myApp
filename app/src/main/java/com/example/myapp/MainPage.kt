package com.example.myapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight

@Composable
fun MainPage() {
    // Kullanıcı ruh hali ve notu için state değişkenleri
    var mood by remember { mutableStateOf("") }
    var note by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Başlık
        Text(
            text = "How are you feeling today?",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Ruh hali seçim butonları
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            MoodButton("😊", "Happy", mood == "Happy") {
                mood = if (mood == "Happy") "" else "Happy"
            }
            MoodButton("😔", "Sad", mood == "Sad") {
                mood = if (mood == "Sad") "" else "Sad"
            }
            MoodButton("😡", "Angry", mood == "Angry") {
                mood = if (mood == "Angry") "" else "Angry"
            }
            MoodButton("😌", "Relaxed", mood == "Relaxed") {
                mood = if (mood == "Relaxed") "" else "Relaxed"
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Not ekleme alanı
        OutlinedTextField(
            value = note,
            onValueChange = { note = it },
            label = { Text("Add a note for today") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = false
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Kaydet butonu
        Button(onClick = {
            // Burada mood ve notu kaydedebilirsiniz
            println("Mood: $mood, Note: $note")
        }) {
            Text("Save Entry")
        }
    }
}




