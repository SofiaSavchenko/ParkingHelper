package com.example.parkinghelper.presentation.screens.home_screen

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.parkinghelper.R
import com.example.parkinghelper.presentation.LeafHomeScreen
import com.example.parkinghelper.presentation.components.PrimaryButton
import com.example.parkinghelper.presentation.screens.home_screen.store.HomeEffect
import com.example.parkinghelper.presentation.screens.home_screen.store.HomeIntent
import com.example.parkinghelper.presentation.screens.home_screen.store.HomeState
import com.example.parkinghelper.presentation.theme.ParkingHelperTheme
import kotlinx.coroutines.flow.MutableSharedFlow

@Composable
fun HomeScreen(
    homeState: State<HomeState>,
    @SuppressLint("ComposeMutableParameters") homeEffect: MutableSharedFlow<HomeEffect>,
    onHomeIntent: (HomeIntent) -> Unit,
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    LaunchedEffect(key1 = Unit) {
        homeEffect.collect { effect ->
            when (effect) {
                HomeEffect.ScanQR -> {

                }

                HomeEffect.GetRandomParkingPlace -> {
                    navHostController.navigate(LeafHomeScreen.RANDOM_PARKING_PLACE_SCREEN)
                }
            }
        }
    }

    Scaffold { paddingValues ->
        Column(
            Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(paddingValues)
                .padding(top = 75.dp)
                .padding(horizontal = 35.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                space = 35.dp,
                alignment = Alignment.Top
            )
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(
                    space = 20.dp,
                    alignment = Alignment.Top
                )
            ) {
                val annotatedString = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onBackground)) {
                        append(stringResource(id = R.string.title_free_places))
                    }
                    append(" ")
                    withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.secondary)) {
                        append(homeState.value.countPlaces.toString())
                    }
                }

                Text(
                    text = annotatedString,
                    style = MaterialTheme.typography.titleMedium
                )

                PrimaryButton(
                    text = stringResource(id = R.string.button_scan_qr),
                    enabled = true,
                    textAlign = TextAlign.Start,
                    onClick = {
                        onHomeIntent(HomeIntent.ScanQR)
                    })
            }

            Column(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(
                    space = 20.dp,
                    alignment = Alignment.Top
                )
            ) {
                Text(
                    text = stringResource(id = R.string.title_get_place),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )

                PrimaryButton(
                    text = stringResource(id = R.string.button_get_random_place),
                    enabled = true,
                    textAlign = TextAlign.Start,
                    onClick = {
                        onHomeIntent(HomeIntent.GetRandomParkingPlace)
                    })
            }
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun HomeScreenPreviewLight() {
    ParkingHelperTheme(dynamicColor = false) {
        val homeViewModel = HomeViewModel()
        HomeScreen(
            homeState = homeViewModel.homeState.collectAsState(),
            homeEffect = homeViewModel.homeEffect,
            onHomeIntent = homeViewModel::onIntent,
            navHostController = rememberNavController()
        )
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun HomeScreenPreviewDark() {
    ParkingHelperTheme(dynamicColor = false) {
        val homeViewModel = HomeViewModel()
        HomeScreen(
            homeState = homeViewModel.homeState.collectAsState(),
            homeEffect = homeViewModel.homeEffect,
            onHomeIntent = homeViewModel::onIntent,
            navHostController = rememberNavController()
        )
    }
}
