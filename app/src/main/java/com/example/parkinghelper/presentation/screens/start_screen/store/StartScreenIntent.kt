package com.example.parkinghelper.presentation.screens.start_screen.store

sealed class StartScreenIntent {
    data object ClickRegistration : StartScreenIntent()
    data object ClickLogin : StartScreenIntent()
}
