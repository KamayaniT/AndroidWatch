package com.example.allywatch.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material3.Card
import androidx.wear.compose.material3.Text
import com.example.allywatch.model.SampleAlertMsg
import androidx.compose.ui.unit.sp

@Composable
fun WarningNotifications() {

    val notifications = listOf(

        SampleAlertMsg(
            title = "Critical",
            message = "Zone violation",
            time = "02/02/2025 08:00 AM"
        ),

        SampleAlertMsg(
            title = "Serious",
            message = "Location Disabled",
            time = "02/02/2025 08:00 AM"
        ),

        SampleAlertMsg(
            title = "Warning",
            message = "Battery Critical",
            time = "02/02/2025 08:00 AM"
        ),

        SampleAlertMsg(
            title = "Low",
            message = "Battery Low",
            time = "02/02/2025 08:00 AM"
        )
    )

    LazyColumn(
        modifier = Modifier.padding(horizontal = 10.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

//        item {
//            Text(
//                text = "Notifications",
//                modifier = Modifier.padding(vertical = 4.dp)
//            )
//        }

        items(notifications) { notification ->

            NotificationItem(notification)
        }
    }
}

@Composable
private fun NotificationItem(
    notification: SampleAlertMsg
) {

    Card(
        onClick = {}
    ) {

        androidx.compose.foundation.layout.Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {

            Text(
                text = notification.title,
                fontSize = 20.sp
            )

            Text(
                text = notification.message,
                fontSize = 10.sp
            )

            Text(
                text = notification.time,
                fontSize = 10.sp
            )
        }
    }
}