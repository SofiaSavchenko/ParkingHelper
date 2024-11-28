package com.example.parkinghelper.presentation.screens.control_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parkinghelper.presentation.screens.control_screen.store.ControlEffect
import com.example.parkinghelper.presentation.screens.control_screen.store.ControlIntent
import com.example.parkinghelper.presentation.screens.control_screen.store.ControlState
import com.example.parkinghelper.presentation.screens.home_screen.store.HomeIntent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ControlViewModel : ViewModel() {

    val controlState = MutableStateFlow(
        ControlState(
            selectedSpace = ""
        )
    )

    val controlEffect = MutableSharedFlow<ControlEffect>()

    fun onIntent(intent: ControlIntent) {
        when (intent) {

            ControlIntent.GetRandomParkingSpace -> {
                viewModelScope.launch {

                }
            }

            ControlIntent.ConfirmParkingSpace -> {
                viewModelScope.launch {
                    controlEffect.emit(ControlEffect.ConfirmParkingSpace)
                }
            }

            ControlIntent.GetAnotherParkingSpace -> {
                viewModelScope.launch {
                    controlEffect.emit(ControlEffect.GetAnotherParkingSpace)
                }
            }

            ControlIntent.ReturnBack -> {
                viewModelScope.launch {
                    controlEffect.emit(ControlEffect.ReturnBack)
                }
            }
        }
    }
}
