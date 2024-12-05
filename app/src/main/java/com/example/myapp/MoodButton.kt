package com.example.myapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MoodButton(emoji: String, moodText: String, isSelected: Boolean, onMoodSelected: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(4.dp)
            .clickable { onMoodSelected() }
    ) {
        // Emoji ve arka planı içine alan Box
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(80.dp)  // Sabit boyut
                .background(
                    color = if (isSelected) MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)
                    else MaterialTheme.colorScheme.surface,
                    shape = CircleShape  // Yuvarlak arka plan
                )
        ) {
            Text(
                text = emoji,
                fontSize = 40.sp,
                modifier = Modifier.align(Alignment.Center)  // Emoji ortalanır
            )
        }
        // Mood Text
        Text(
            text = moodText,
            fontSize = 14.sp
        )
    }
}




