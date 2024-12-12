package com.example.parkinghelper.presentation.screens.get_random_space_screen

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.example.parkinghelper.presentation.components.SecondaryButton
import com.example.parkinghelper.presentation.screens.get_random_space_screen.store.GetRandomSpaceEffect
import com.example.parkinghelper.presentation.screens.get_random_space_screen.store.GetRandomSpaceIntent
import com.example.parkinghelper.presentation.screens.get_random_space_screen.store.GetRandomSpaceState
import com.example.parkinghelper.presentation.theme.ParkingHelperTheme
import kotlinx.coroutines.flow.MutableSharedFlow

@Composable
fun GetRandomSpaceScreen(
    getRandomSpaceState: State<GetRandomSpaceState>,
    @SuppressLint("ComposeMutableParameters") getRandomSpaceEffect: MutableSharedFlow<GetRandomSpaceEffect>,
    onGetRandomSpaceIntent: (GetRandomSpaceIntent) -> Unit,
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    LaunchedEffect(key1 = Unit) {
        getRandomSpaceEffect.collect { effect ->
            when (effect) {
                GetRandomSpaceEffect.ConfirmParkingSpace -> {

                }

                GetRandomSpaceEffect.GetAnotherParkingSpace -> {

                }

                GetRandomSpaceEffect.ReturnBack -> {
                    navHostController.navigateUp()
                }
            }
        }
    }
    Scaffold(
        modifier = modifier,
        topBar = {
            Row(
                modifier = Modifier
                    .padding(top = 12.dp, start = 16.dp, end = 16.dp)
            ) {
                IconButton(
                    onClick = {
                        onGetRandomSpaceIntent(GetRandomSpaceIntent.ReturnBack)
                    }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                        tint = MaterialTheme.colorScheme.onBackground,
                        contentDescription = stringResource(id = R.string.header_back_content_desc),
                        modifier = Modifier.size(32.dp)
                    )
                }
            }
        }
    ) { paddingValues ->

        Column(
            Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(paddingValues)
                .padding(top = 160.dp)
                .padding(horizontal = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                space = 65.dp,
                alignment = Alignment.Top
            )
        ) {
            val annotatedString = buildAnnotatedString {
                withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onBackground)) {
                    append(stringResource(id = R.string.title_your_parking_space))
                }
                append(" ")
                withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.secondary)) {
                    append(getRandomSpaceState.value.selectedSpace)
                }
            }

            Text(
                text = annotatedString,
                style = MaterialTheme.typography.titleLarge
            )

            Column(
                modifier = Modifier
                    .padding()
                    .align(Alignment.Start),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(space = 20.dp, alignment = Alignment.Top)
            ) {
                PrimaryButton(
                    text = stringResource(id = R.string.button_confirm_parking_space),
                    enabled = true,
                    onClick = {
                        onGetRandomSpaceIntent(GetRandomSpaceIntent.ConfirmParkingSpace)
                    })
                SecondaryButton(
                    text = stringResource(id = R.string.button_get_another_space),
                    enabled = true,
                    onClick = {
                        onGetRandomSpaceIntent(GetRandomSpaceIntent.GetAnotherParkingSpace)
                    })
            }
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun GetRandomSpaceScreenPreviewLight() {
    ParkingHelperTheme(dynamicColor = false) {
        val getRandomSpaceViewModel = GetRandomSpaceViewModel()
        GetRandomSpaceScreen(
            getRandomSpaceState = getRandomSpaceViewModel.getRandomSpaceState.collectAsState(),
            getRandomSpaceEffect = getRandomSpaceViewModel.getRandomSpaceEffect,
            onGetRandomSpaceIntent = getRandomSpaceViewModel::onIntent,
            navHostController = rememberNavController()
        )
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun GetRandomSpaceScreenPreviewDark() {
    ParkingHelperTheme(dynamicColor = false) {
        val getRandomSpaceViewModel = GetRandomSpaceViewModel()
        GetRandomSpaceScreen(
            getRandomSpaceState = getRandomSpaceViewModel.getRandomSpaceState.collectAsState(),
            getRandomSpaceEffect = getRandomSpaceViewModel.getRandomSpaceEffect,
            onGetRandomSpaceIntent = getRandomSpaceViewModel::onIntent,
            navHostController = rememberNavController()
        )
    }
}
