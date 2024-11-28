package com.example.parkinghelper.presentation.screens.control_screen.store

sealed class ControlIntent {
    data object GetRandomParkingSpace: ControlIntent()
    data object ConfirmParkingSpace : ControlIntent()
    data object GetAnotherParkingSpace : ControlIntent()
    data object ReturnBack : ControlIntent()
}
