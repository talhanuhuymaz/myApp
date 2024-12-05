package com.example.myapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight

@Composable
fun MainPage() {
    // Ruh hali ve not bilgisi
    var mood by remember { mutableStateOf("") }
    var note by remember { mutableStateOf("") }
    var savedEntries by remember { mutableStateOf<List<Pair<String, String>>>(emptyList()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Başlık
        Text(
            text = "How are you feeling today?",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(top = 16.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Ruh hali seçim kartları
        MoodSelection(
            onMoodSelected = { mood = it }
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Seçilen ruh hali
        if (mood.isNotEmpty()) {
            Text(
                text = "You selected: $mood",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Not ekleme alanı
        OutlinedTextField(
            value = note,
            onValueChange = { note = it },
            label = { Text("Add a note for today") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = MaterialTheme.shapes.medium
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Kaydet butonu
        Button(
            onClick = {
                if (mood.isNotEmpty() && note.isNotEmpty()) {
                    savedEntries = savedEntries + Pair(mood, note)
                    mood = ""
                    note = ""
                }
            },
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save Entry")
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Kaydedilen notlar
        if (savedEntries.isNotEmpty()) {
            Text(
                text = "Your Entries",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(8.dp))
            savedEntries.forEachIndexed { index, entry ->
                EntryCard(mood = entry.first, note = entry.second)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun MoodSelection(onMoodSelected: (String) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        listOf(
            "😊" to "Happy",
            "😔" to "Sad",
            "😡" to "Angry",
            "😌" to "Relaxed"
        ).forEach { (emoji, mood) ->
            MoodCard(
                emoji = emoji,
                mood = mood,
                onClick = { onMoodSelected(mood) }
            )
        }
    }
}

@Composable
fun MoodCard(emoji: String, mood: String, onClick: () -> Unit) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .size(80.dp)
            .clickable { onClick() },
        elevation = CardDefaults.elevatedCardElevation(4.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = emoji,
                fontSize = 30.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = mood,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
fun EntryCard(mood: String, note: String) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        elevation = CardDefaults.elevatedCardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = mood,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = note,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

