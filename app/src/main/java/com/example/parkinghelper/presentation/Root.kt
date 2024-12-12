package com.example.parkinghelper.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.parkinghelper.navigation.NavGraph
import com.example.parkinghelper.presentation.components.BottomBar
import com.example.parkinghelper.presentation.theme.ParkingHelperTheme

@SuppressLint("ComposeModifierMissing")
@Composable
fun Root() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            val backStackEntry: NavBackStackEntry? by navController.currentBackStackEntryAsState()
            val currentRoute = backStackEntry?.destination?.route
            if (currentRoute != null) {
                if (getIsShowBottomBar(currentRoute))
                    BottomBar(navController = navController)
            }
        }
    ) { paddingValues ->
        NavGraph(
            navHostController = navController,
            modifier = Modifier.padding(paddingValues)
        )
    }
}

private fun getIsShowBottomBar(currentRoute: String): Boolean {
    return currentRoute != RootScreen.START_SCREEN &&
            currentRoute != LeafScreen.START_SCREEN &&
            currentRoute != LeafScreen.REGISTRATION_SCREEN &&
            currentRoute != LeafScreen.AUTHORIZATION_SCREEN
}

@Preview
@Composable
private fun RootPreview() {
    ParkingHelperTheme(dynamicColor = false) {
        Surface(color = MaterialTheme.colorScheme.onBackground) {
            Root()
        }
    }
}
