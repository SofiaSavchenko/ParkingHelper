package com.example.parkinghelper.presentation.screens.start_screen.store

sealed class StartScreenEffect {
    data object ClickRegistration : StartScreenEffect()
    data object ClickLogin : StartScreenEffect()
}
