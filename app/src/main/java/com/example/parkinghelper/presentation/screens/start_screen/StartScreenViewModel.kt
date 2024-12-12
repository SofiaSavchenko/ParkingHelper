package com.example.parkinghelper.presentation.screens.start_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parkinghelper.presentation.screens.start_screen.store.StartScreenEffect
import com.example.parkinghelper.presentation.screens.start_screen.store.StartScreenIntent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StartScreenViewModel @Inject constructor(): ViewModel() {

    val startScreenEffect = MutableSharedFlow<StartScreenEffect>()

    fun onIntent(startScreenIntent: StartScreenIntent) {
        when (startScreenIntent) {
            StartScreenIntent.ClickLogin -> {
                viewModelScope.launch {
                    startScreenEffect.emit(StartScreenEffect.ClickLogin)
                }
            }

            StartScreenIntent.ClickRegistration -> {
                viewModelScope.launch {
                    startScreenEffect.emit(StartScreenEffect.ClickRegistration)
                }
            }
        }
    }
}
