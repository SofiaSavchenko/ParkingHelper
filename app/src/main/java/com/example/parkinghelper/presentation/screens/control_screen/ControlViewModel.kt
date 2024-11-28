package com.example.parkinghelper.presentation.screens.control_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parkinghelper.presentation.screens.control_screen.store.ControlEffect
import com.example.parkinghelper.presentation.screens.control_screen.store.ControlIntent
import com.example.parkinghelper.presentation.screens.control_screen.store.ControlState
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

            ControlIntent.MarkAsBusy -> {
                viewModelScope.launch {
                    controlEffect.emit(ControlEffect.MarkAsBusy)
                }
            }

            ControlIntent.MarkAsFree -> {
                viewModelScope.launch {
                    controlEffect.emit(ControlEffect.MarkAsFree)
                }
            }

            ControlIntent.CancelReservation -> {
                viewModelScope.launch {
                    controlEffect.emit(ControlEffect.CancelReservation)
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
