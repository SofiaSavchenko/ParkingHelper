package com.example.parkinghelper.presentation.screens.control_screen.store

sealed class ControlIntent {
    data object MarkAsBusy : ControlIntent()
    data object MarkAsFree : ControlIntent()
    data object CancelReservation : ControlIntent()
    data object ReturnBack : ControlIntent()
}
