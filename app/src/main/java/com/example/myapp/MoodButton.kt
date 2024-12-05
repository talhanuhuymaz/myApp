package com.example.myapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MoodButton(emoji: String, moodText: String, onMoodSelected: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable { onMoodSelected() }
            .padding(8.dp)
            .size(80.dp)
    ) {
        // Emoji'yi göster
        Text(text = emoji, fontSize = 30.sp)
        // Mood metnini göster
        Text(text = moodText, fontSize = 14.sp)
    }
}
