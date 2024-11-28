package com.example.parkinghelper.presentation.screens.home_screen.store

sealed class HomeEffect {
    data object ScanQR : HomeEffect()
    data object GetRandomParkingPlace : HomeEffect()
}
