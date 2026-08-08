package com.example.allywatch.ui

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.wear.compose.material3.Button
import androidx.wear.compose.material3.Text
import com.example.allywatch.location.LocationRepository
import kotlinx.coroutines.launch

@Composable
fun LocationScreen() {

    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    var location by remember {
        mutableStateOf<Location?>(null)
    }

    var isLoading by remember {
        mutableStateOf(false)
    }

    var errorMessage by remember {
        mutableStateOf<String?>(null)
    }

    val locationRepository = remember {
        LocationRepository(context)
    }

    fun loadLocation() {

        scope.launch {

            isLoading = true
            errorMessage = null

            val result = locationRepository.getCurrentLocation()

            if (result != null) {
                location = result
            } else {
                errorMessage = "Unable to get location"
            }

            isLoading = false
        }
    }

    val permissionLauncher =
        rememberLauncherForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->

            val fineGranted =
                permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true

            if (fineGranted) {
                loadLocation()
            } else {
                errorMessage = "Location permission required"
            }
        }

    fun requestLocation() {

        val finePermission =
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            )

        if (finePermission == PackageManager.PERMISSION_GRANTED) {
            loadLocation()
        } else {
            permissionLauncher.launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
        }
    }

    LaunchedEffect(Unit) {
        requestLocation()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text("Current Location")

        if (isLoading) {

            Text("Getting location...")

        } else if (location != null) {

            val currentLocation = location!!

            Text(
                text = String.format(
                    "Lat: %.6f",
                    currentLocation.latitude
                )
            )

            Text(
                text = String.format(
                    "Lon: %.6f",
                    currentLocation.longitude
                )
            )

            Text(
                text = String.format(
                    "Accuracy: %.1f m",
                    currentLocation.accuracy
                )
            )

            Button(
                onClick = {
                    requestLocation()
                }
            ) {
                Text("Refresh")
            }

        } else {

            errorMessage?.let {
                Text(it)
            }

            Button(
                onClick = {
                    requestLocation()
                }
            ) {
                Text("Try Again")
            }
        }
    }
}