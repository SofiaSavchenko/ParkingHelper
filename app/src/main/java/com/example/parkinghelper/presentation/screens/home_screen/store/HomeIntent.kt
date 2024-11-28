package com.example.parkinghelper.presentation.screens.home_screen.store

sealed class HomeIntent {
    data object ScanQR : HomeIntent()
    data object GetFreeParkingPlaces : HomeIntent()
    data object GetRandomParkingPlace : HomeIntent()
}
