package com.example.parkinghelper.presentation.screens.control_screen.store

sealed class ControlEffect {
    data object ConfirmParkingSpace : ControlEffect()
    data object GetAnotherParkingSpace : ControlEffect()
    data object ReturnBack : ControlEffect()
}
