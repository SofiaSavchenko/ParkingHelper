package com.example.parkinghelper.presentation.screens.get_random_space_screen.store

sealed class GetRandomSpaceIntent {
    data object GetRandomParkingSpace: GetRandomSpaceIntent()
    data object ConfirmParkingSpace : GetRandomSpaceIntent()
    data object GetAnotherParkingSpace : GetRandomSpaceIntent()
    data object ReturnBack : GetRandomSpaceIntent()
}
