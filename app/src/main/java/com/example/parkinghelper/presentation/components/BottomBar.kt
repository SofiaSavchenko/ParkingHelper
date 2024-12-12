package com.example.parkinghelper.presentation.components

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.parkinghelper.navigation.BottomNavItem
import com.example.parkinghelper.presentation.theme.ParkingHelperTheme

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val navigationItems = listOf(
        BottomNavItem.Home,
        BottomNavItem.Control,
        BottomNavItem.Profile
    )

    NavigationBar(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        containerColor = MaterialTheme.colorScheme.background
    ) {
        val backStackEntry: NavBackStackEntry? by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route

        navigationItems.forEach { item ->
            NavigationBarItem(
                modifier = modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                selected = currentRoute == item.route || item.list.any { subitem -> currentRoute == subitem },
                onClick = {
                    navController.navigate(item.route)
                },
                icon = {
                    Icon(
                        modifier = Modifier
                            .size(24.dp)
                            .fillMaxWidth(),
                        painter = painterResource(id = item.iconId),
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = item.title),
                        style = MaterialTheme.typography.labelSmall
                    )
                },
                colors = NavigationBarItemDefaults.colors().copy(
                    selectedIconColor = MaterialTheme.colorScheme.secondary,
                    selectedTextColor = MaterialTheme.colorScheme.secondary,
                    selectedIndicatorColor = Color.Transparent,
                    unselectedIconColor = MaterialTheme.colorScheme.surface,
                    unselectedTextColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
private fun BottomBarPreviewLight() {
    ParkingHelperTheme(dynamicColor = false) {
        Scaffold(bottomBar = { BottomBar(navController = rememberNavController()) }) {}
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun BottomBarPreviewDark() {
    ParkingHelperTheme(dynamicColor = false) {
        Scaffold(bottomBar = { BottomBar(navController = rememberNavController()) }) {}
    }
}
