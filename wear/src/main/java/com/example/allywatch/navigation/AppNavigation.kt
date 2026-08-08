package com.example.allywatch.navigation

import androidx.compose.runtime.Composable
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController

import com.example.allywatch.ui.CalendarScreen
import com.example.allywatch.ui.HomeScreen
import com.example.allywatch.ui.LocationScreen
import com.example.allywatch.ui.WarningNotifications
import com.example.allywatch.ui.PanicScreen

object Routes {
    const val HOME = "home"
    const val LOCATION = "location"
    const val PANIC = "panic"
    const val NOTIFICATIONS = "notifications"
    const val CALENDAR = "calendar"
}

@Composable
fun AppNavigation() {

    val navController = rememberSwipeDismissableNavController()

    SwipeDismissableNavHost(
        navController = navController,
        startDestination = Routes.HOME
    ) {

        composable(Routes.HOME) {
            HomeScreen(
                onLocationClick = {
                    navController.navigate(Routes.LOCATION)
                },
                onPanicClick = {
                    navController.navigate(Routes.PANIC)
                },
                onNotificationsClick = {
                    navController.navigate(Routes.NOTIFICATIONS)
                },
                onCalendarClick = {
                    navController.navigate(Routes.CALENDAR)
                }
            )
        }

        composable(Routes.LOCATION) {
            LocationScreen()
        }

        composable(Routes.PANIC) {
            PanicScreen()
        }

        composable(Routes.NOTIFICATIONS) {
            WarningNotifications()
        }

        composable(Routes.CALENDAR) {
            CalendarScreen()
        }
    }
}