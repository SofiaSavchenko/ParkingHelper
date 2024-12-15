package com.example.parkinghelper.presentation.screens.qr_screen.store

sealed class QrIntent {
    data object ReturnBack : QrIntent()
}
