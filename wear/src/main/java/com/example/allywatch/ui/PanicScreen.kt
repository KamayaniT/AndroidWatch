package com.example.allywatch.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material3.Button
import androidx.wear.compose.material3.Text

@Composable
fun PanicScreen() {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

//        Text(
//            text = "Emergency Call"
//        )
//
//        Spacer(
//            modifier = Modifier.height(2.dp)
//        )

        Text(
            text = "Do you want to dial 911?"
        )

        Spacer(
            modifier = Modifier.height(2.dp)
        )

        Button(
            onClick = {

                val intent = Intent(
                    Intent.ACTION_DIAL,
                    Uri.parse("tel:911")
                )

                context.startActivity(intent)
            }
        ) {
            Text("DIAL 911")
        }

        Spacer(
            modifier = Modifier.height(2.dp)
        )

        Button(
            onClick = {
                // Swipe back to return to the home screen
            }
        ) {
            Text("CANCEL")
        }
    }
}
