package com.example.allywatch.ui

import android.content.Intent
import android.provider.CalendarContract
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material3.Button
import androidx.wear.compose.material3.Text
import java.util.Calendar

@Composable
fun CalendarScreen() {

    val context = LocalContext.current

    val today = Calendar.getInstance()

    val startOfDay = Calendar.getInstance().apply {
        set(
            today.get(Calendar.YEAR),
            today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH),
            0,
            0,
            0
        )
    }

    val intent = Intent(
        Intent.ACTION_VIEW
    ).apply {
        data = CalendarContract.CONTENT_URI
        putExtra(
            CalendarContract.EXTRA_EVENT_BEGIN_TIME,
            startOfDay.timeInMillis
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text("Calendar")

        Button(
            onClick = {
                context.startActivity(intent)
            }
        ) {
            Text("Open Calendar")
        }
    }
}