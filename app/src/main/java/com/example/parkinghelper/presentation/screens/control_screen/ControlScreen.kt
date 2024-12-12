package com.example.parkinghelper.presentation.screens.control_screen

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.parkinghelper.R
import com.example.parkinghelper.presentation.components.PrimaryButton
import com.example.parkinghelper.presentation.components.ScreenHeader
import com.example.parkinghelper.presentation.components.SecondaryButton
import com.example.parkinghelper.presentation.screens.control_screen.store.ControlEffect
import com.example.parkinghelper.presentation.screens.control_screen.store.ControlIntent
import com.example.parkinghelper.presentation.screens.control_screen.store.ControlState
import com.example.parkinghelper.presentation.theme.ParkingHelperTheme
import kotlinx.coroutines.flow.MutableSharedFlow

@Composable
fun ControlScreen(
    controlState: State<ControlState>,
    @SuppressLint("ComposeMutableParameters") controlEffect: MutableSharedFlow<ControlEffect>,
    onControlIntent: (ControlIntent) -> Unit,
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    LaunchedEffect(key1 = Unit) {
        controlEffect.collect { effect ->
            when (effect) {
                ControlEffect.MarkAsBusy -> {

                }

                ControlEffect.MarkAsFree -> {

                }

                ControlEffect.CancelReservation -> {

                }

                ControlEffect.ReturnBack -> {
                    navHostController.navigateUp()
                }
            }
        }
    }
    Scaffold(
        topBar = {
            ScreenHeader(
                modifier = Modifier
                    .padding(top = 12.dp, start = 16.dp, end = 16.dp)
                    .padding(
                        top = WindowInsets.statusBars
                            .asPaddingValues()
                            .calculateTopPadding()
                    ),
                title = stringResource(
                    id = R.string.title_control_screen
                ),
                onNavigateBack = {
                    onControlIntent(ControlIntent.ReturnBack)
                }
            )
        }
    ) { paddingValues ->

        Column(
            Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(paddingValues)
                .padding(top = 30.dp, bottom = 20.dp)
                .padding(horizontal = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                space = 24.dp,
                alignment = Alignment.Top
            )
        ) {
            val annotatedString = buildAnnotatedString {
                withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onBackground)) {
                    append(stringResource(id = R.string.title_reservation_space))
                }
                append(" ")
                withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.secondary)) {
                    append(controlState.value.selectedSpace)
                }
            }

            Text(
                text = annotatedString,
                style = MaterialTheme.typography.titleMedium
            )

            Column(
                modifier = Modifier
                    .padding()
                    .align(Alignment.Start),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(space = 20.dp, alignment = Alignment.Top)
            ) {
                PrimaryButton(
                    text = stringResource(id = R.string.button_mark_as_busy),
                    enabled = true,
                    onClick = {
                        onControlIntent(ControlIntent.MarkAsBusy)
                    })
                SecondaryButton(
                    text = stringResource(id = R.string.button_mark_as_free),
                    enabled = true,
                    onClick = {
                        onControlIntent(ControlIntent.MarkAsFree)
                    })

                Spacer(modifier = Modifier.weight(1f))

                SecondaryButton(
                    text = stringResource(id = R.string.button_cancel_reservation),
                    enabled = true,
                    buttonColor = MaterialTheme.colorScheme.surface,
                    onClick = {
                        onControlIntent(ControlIntent.CancelReservation)
                    })
            }
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun ControlScreenPreviewLight() {
    ParkingHelperTheme(dynamicColor = false) {
        val controlViewModel = ControlViewModel()
        ControlScreen(
            controlState = controlViewModel.controlState.collectAsState(),
            controlEffect = controlViewModel.controlEffect,
            onControlIntent = controlViewModel::onIntent,
            navHostController = rememberNavController()
        )
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ControlScreenPreviewDark() {
    ParkingHelperTheme(dynamicColor = false) {
        val controlViewModel = ControlViewModel()
        ControlScreen(
            controlState = controlViewModel.controlState.collectAsState(),
            controlEffect = controlViewModel.controlEffect,
            onControlIntent = controlViewModel::onIntent,
            navHostController = rememberNavController()
        )
    }
}
