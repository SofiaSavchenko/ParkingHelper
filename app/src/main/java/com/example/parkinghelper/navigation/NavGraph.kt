package com.example.parkinghelper.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.parkinghelper.presentation.LeafHomeScreen
import com.example.parkinghelper.presentation.LeafScreen
import com.example.parkinghelper.presentation.RootScreen
import com.example.parkinghelper.presentation.screens.control_screen.ControlScreen
import com.example.parkinghelper.presentation.screens.control_screen.ControlViewModel
import com.example.parkinghelper.presentation.screens.control_screen.store.ControlState
import com.example.parkinghelper.presentation.screens.get_random_space_screen.GetRandomSpaceScreen
import com.example.parkinghelper.presentation.screens.get_random_space_screen.GetRandomSpaceViewModel
import com.example.parkinghelper.presentation.screens.get_random_space_screen.store.GetRandomSpaceState
import com.example.parkinghelper.presentation.screens.home_screen.HomeScreen
import com.example.parkinghelper.presentation.screens.home_screen.HomeViewModel
import com.example.parkinghelper.presentation.screens.home_screen.store.HomeState
import com.example.parkinghelper.presentation.screens.start_screen.StartScreen
import com.example.parkinghelper.presentation.screens.start_screen.StartScreenViewModel

@Composable
fun NavGraph(navHostController: NavHostController, modifier: Modifier = Modifier) {

    NavHost(
        navController = navHostController,
        startDestination = RootScreen.START_SCREEN
    ) {
        navigation(
            route = RootScreen.START_SCREEN,
            startDestination = LeafScreen.START_SCREEN
        ) {
            composable(
                route = LeafScreen.START_SCREEN
            ) {
                val startViewModel: StartScreenViewModel = hiltViewModel()
                StartScreen(
                    startScreenEffect = startViewModel.startScreenEffect,
                    onStartScreenIntent = startViewModel::onIntent,
                    navHostController = navHostController
                )
            }
            composable(
                route = LeafHomeScreen.HOME_SCREEN
            ) {
                val homeViewModel: HomeViewModel = hiltViewModel()
                HomeScreen(
                    homeState = homeViewModel.homeState.collectAsState(
                        initial = HomeState(
                            countPlaces = 0
                        )
                    ),
                    homeEffect = homeViewModel.homeEffect,
                    onHomeIntent = homeViewModel::onIntent,
                    navHostController = navHostController,
                    modifier = modifier
                )
            }
        }

        navigation(
            route = RootScreen.HOME_SCREEN,
            startDestination = LeafHomeScreen.HOME_SCREEN
        ) {
            composable(
                route = LeafHomeScreen.HOME_SCREEN
            ) {
                val homeViewModel: HomeViewModel = hiltViewModel()
                HomeScreen(
                    homeState = homeViewModel.homeState.collectAsState(
                        initial = HomeState(
                            countPlaces = 0
                        )
                    ),
                    homeEffect = homeViewModel.homeEffect,
                    onHomeIntent = homeViewModel::onIntent,
                    navHostController = navHostController,
                    modifier = modifier
                )
            }
            composable(
                route = LeafHomeScreen.RANDOM_PARKING_PLACE_SCREEN
            ) {
                val randomViewModel: GetRandomSpaceViewModel = hiltViewModel()
                GetRandomSpaceScreen(
                    getRandomSpaceState = randomViewModel.getRandomSpaceState.collectAsState(
                        initial = GetRandomSpaceState(
                            selectedSpace = ""
                        )
                    ),
                    getRandomSpaceEffect = randomViewModel.getRandomSpaceEffect,
                    onGetRandomSpaceIntent = randomViewModel::onIntent,
                    navHostController = navHostController,
                    modifier = modifier
                )
            }
        }

        navigation(
            route = RootScreen.CONTROL_SCREEN,
            startDestination = LeafScreen.CONTROL_SCREEN
        ) {
            composable(
                route = LeafScreen.CONTROL_SCREEN
            ) {
                val controlViewModel: ControlViewModel = hiltViewModel()
                ControlScreen(
                    controlState = controlViewModel.controlState.collectAsState(
                        initial = ControlState(
                            selectedSpace = ""
                        )
                    ),
                    controlEffect = controlViewModel.controlEffect,
                    onControlIntent = controlViewModel::onIntent,
                    navHostController = navHostController,
                    modifier = modifier
                )
            }
        }

        navigation(
            route = RootScreen.PROFILE_SCREEN,
            startDestination = LeafScreen.PROFILE_SCREEN
        ) {
            composable(
                route = LeafScreen.PROFILE_SCREEN
            ) {

            }
        }
    }
}
