package com.example.parkinghelper.presentation.screens.control_screen.store

sealed class ControlEffect {
    data object MarkAsBusy : ControlEffect()
    data object MarkAsFree : ControlEffect()
    data object CancelReservation : ControlEffect()
    data object ReturnBack : ControlEffect()
}
