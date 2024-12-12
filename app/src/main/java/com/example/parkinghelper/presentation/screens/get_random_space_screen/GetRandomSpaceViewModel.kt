package com.example.parkinghelper.presentation.screens.get_random_space_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parkinghelper.presentation.screens.get_random_space_screen.store.GetRandomSpaceEffect
import com.example.parkinghelper.presentation.screens.get_random_space_screen.store.GetRandomSpaceIntent
import com.example.parkinghelper.presentation.screens.get_random_space_screen.store.GetRandomSpaceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GetRandomSpaceViewModel @Inject constructor(): ViewModel() {

    val getRandomSpaceState = MutableStateFlow(
        GetRandomSpaceState(
            selectedSpace = ""
        )
    )

    val getRandomSpaceEffect = MutableSharedFlow<GetRandomSpaceEffect>()

    fun onIntent(intent: GetRandomSpaceIntent) {
        when (intent) {

            GetRandomSpaceIntent.GetRandomParkingSpace -> {
                viewModelScope.launch {

                }
            }

            GetRandomSpaceIntent.ConfirmParkingSpace -> {
                viewModelScope.launch {
                    getRandomSpaceEffect.emit(GetRandomSpaceEffect.ConfirmParkingSpace)
                }
            }

            GetRandomSpaceIntent.GetAnotherParkingSpace -> {
                viewModelScope.launch {
                    getRandomSpaceEffect.emit(GetRandomSpaceEffect.GetAnotherParkingSpace)
                }
            }

            GetRandomSpaceIntent.ReturnBack -> {
                viewModelScope.launch {
                    getRandomSpaceEffect.emit(GetRandomSpaceEffect.ReturnBack)
                }
            }
        }
    }
}
