package com.example.parkinghelper.navigation

import com.example.parkinghelper.R
import com.example.parkinghelper.presentation.LeafHomeScreen
import com.example.parkinghelper.presentation.LeafScreen
import com.example.parkinghelper.presentation.RootScreen

sealed class BottomNavItem(
    val title: Int,
    val iconId: Int,
    val route: String,
    val list: List<String>
) {
    data object Home : BottomNavItem(
        R.string.home_screen_label,
        R.drawable.home_icon,
        RootScreen.HOME_SCREEN,
        listOf(
            LeafHomeScreen.HOME_SCREEN,
            LeafHomeScreen.RANDOM_PARKING_PLACE_SCREEN
        )
    )

    data object Control : BottomNavItem(
        R.string.control_screen_label,
        R.drawable.control_icon,
        RootScreen.CONTROL_SCREEN,
        listOf(LeafScreen.CONTROL_SCREEN)
    )

    data object Profile : BottomNavItem(
        R.string.profile_screen_label,
        R.drawable.profile_icon,
        RootScreen.PROFILE_SCREEN,
        listOf(LeafScreen.PROFILE_SCREEN)
    )
}
