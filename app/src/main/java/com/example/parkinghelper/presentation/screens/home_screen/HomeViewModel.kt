package com.example.parkinghelper.presentation.screens.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parkinghelper.presentation.screens.home_screen.store.HomeEffect
import com.example.parkinghelper.presentation.screens.home_screen.store.HomeIntent
import com.example.parkinghelper.presentation.screens.home_screen.store.HomeState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    val homeState = MutableStateFlow(
        HomeState(
            countPlaces = 0
        )
    )

    val homeEffect = MutableSharedFlow<HomeEffect>()

    fun onIntent(intent: HomeIntent) {
        when (intent) {

            HomeIntent.GetFreeParkingPlaces -> {
                viewModelScope.launch {

                }
            }

            HomeIntent.GetRandomParkingPlace -> {
                viewModelScope.launch {
                    homeEffect.emit(HomeEffect.GetRandomParkingPlace)
                }
            }

            HomeIntent.ScanQR -> {
                viewModelScope.launch {
                    homeEffect.emit(HomeEffect.ScanQR)
                }
            }
        }
    }
}
