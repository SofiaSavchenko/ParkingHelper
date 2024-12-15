package com.example.parkinghelper.presentation.screens.qr_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parkinghelper.presentation.screens.qr_screen.store.QrEffect
import com.example.parkinghelper.presentation.screens.qr_screen.store.QrIntent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QrViewModel @Inject constructor() : ViewModel() {

    val qrEffect = MutableSharedFlow<QrEffect>()

    fun onIntent(intent: QrIntent) {
        when (intent) {

            QrIntent.ReturnBack -> {
                viewModelScope.launch {
                    qrEffect.emit(QrEffect.ReturnBack)
                }
            }
        }
    }
}
