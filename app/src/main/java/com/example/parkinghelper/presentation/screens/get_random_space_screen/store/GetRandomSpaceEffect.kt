package com.example.parkinghelper.presentation.screens.get_random_space_screen.store

sealed class GetRandomSpaceEffect {
    data object ConfirmParkingSpace : GetRandomSpaceEffect()
    data object GetAnotherParkingSpace : GetRandomSpaceEffect()
    data object ReturnBack : GetRandomSpaceEffect()
}
