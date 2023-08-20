package com.groot.composable

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.groot.composable.ui.screen.LandingScreen

@Composable
fun NavigationController(
    navController: NavHostController = rememberNavController(),
    startDestination: String = NavDest.landingScreen
) {

    NavHost(navController, startDestination,
        builder = {
            composable(NavDest.landingScreen) {
                LandingScreen(navController)
            }

            composable(NavDest.composableListScreen) {
                LandingScreen(navController)
            }

        }
    )
}


object NavDest {

    const val landingScreen = "landingScreen"
    const val composableListScreen = "composableListScreen"
}

