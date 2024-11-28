package com.example.parkinghelper.presentation.screens.start_screen

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.parkinghelper.R
import com.example.parkinghelper.presentation.components.PrimaryButton
import com.example.parkinghelper.presentation.components.SecondaryButton
import com.example.parkinghelper.presentation.screens.start_screen.store.StartScreenEffect
import com.example.parkinghelper.presentation.screens.start_screen.store.StartScreenIntent
import com.example.parkinghelper.presentation.theme.ParkingHelperTheme
import kotlinx.coroutines.flow.MutableSharedFlow

@SuppressLint("ComposeModifierMissing")
@Composable
fun StartScreen(
    onStartScreenIntent: (StartScreenIntent) -> Unit,
    @SuppressLint("ComposeMutableParameters") startScreenEffect: MutableSharedFlow<StartScreenEffect>,
    navHostController: NavHostController
) {
    LaunchedEffect(key1 = Unit) {
        startScreenEffect.collect { effect ->
            when (effect) {
                StartScreenEffect.ClickLogin -> {}
                StartScreenEffect.ClickRegistration -> {}
            }
        }
    }

    Column(
        Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            space = 80.dp,
            alignment = Alignment.CenterVertically
        )
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .align(Alignment.Start)
        ) {
            Text(
                text = stringResource(id = R.string.app_title),
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onSecondary
            )
            Text(
                text = stringResource(id = R.string.app_subtitle),
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onSecondary
            )
            Spacer(Modifier.height(12.dp))

            Text(
                text = stringResource(id = R.string.description_app),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.tertiary
            )

        }

        Column(
            modifier = Modifier
                .padding()
                .align(Alignment.Start),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(space = 20.dp, alignment = Alignment.Top)
        ) {
            PrimaryButton(
                text = stringResource(id = R.string.button_registration),
                enabled = true,
                onClick = {
                    onStartScreenIntent(StartScreenIntent.ClickRegistration)
                })
            SecondaryButton(
                text = stringResource(id = R.string.button_auth),
                enabled = true,
                onClick = {
                    onStartScreenIntent(StartScreenIntent.ClickLogin)
                })
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun StartScreenPreviewLight() {
    ParkingHelperTheme(dynamicColor = false) {
        val startScreenViewModel = StartScreenViewModel()
        StartScreen(
            onStartScreenIntent = startScreenViewModel::onIntent,
            startScreenEffect = startScreenViewModel.startScreenEffect,
            navHostController = rememberNavController()
        )
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = false, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun StartScreenPreviewDark() {
    ParkingHelperTheme(dynamicColor = false) {
        val startScreenViewModel = StartScreenViewModel()
        StartScreen(
            onStartScreenIntent = startScreenViewModel::onIntent,
            startScreenEffect = startScreenViewModel.startScreenEffect,
            navHostController = rememberNavController()
        )
    }
}
