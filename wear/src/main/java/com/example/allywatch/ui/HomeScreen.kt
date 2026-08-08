package com.example.allywatch.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.wear.compose.material3.MaterialTheme
import androidx.wear.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material3.Text
import com.example.allywatch.R

@Composable
fun HomeScreen(
    onLocationClick: () -> Unit,
    onPanicClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onCalendarClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            MenuItem(
                iconRes = R.drawable.location,
                label = "Location",
                backgroundColor = MaterialTheme.colorScheme.primary,
                onClick = onLocationClick
            )

            MenuItem(
                iconRes = R.drawable.panic,
                label = "Panic",
                backgroundColor = MaterialTheme.colorScheme.error,
                onClick = onPanicClick
            )
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            MenuItem(
                iconRes = R.drawable.notification,
                label = "Notifications",
                backgroundColor = MaterialTheme.colorScheme.secondary,
                onClick = onNotificationsClick
            )

            MenuItem(
                iconRes = R.drawable.calendar,
                label = "Calendar",
                backgroundColor = MaterialTheme.colorScheme.tertiary,
                onClick = onCalendarClick
            )
        }
    }
}

@Composable
private fun MenuItem(
    iconRes: Int,
    label: String,
    backgroundColor: Color,
    onClick: () -> Unit
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        IconButton(
            onClick = onClick,
            modifier = Modifier
                .size(54.dp)
                .background(
                    color = backgroundColor,
                    shape = CircleShape
                )
        ) {

            androidx.compose.foundation.Image(
                painter = painterResource(id = iconRes),
                contentDescription = label,
                modifier = Modifier.size(32.dp)
            )
        }

        Spacer(
            modifier = Modifier.height(4.dp)
        )

//        Text(
//            text = label
//        )
    }
}
