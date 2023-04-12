package com.example.bibleprojekt.ui.components

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bibleprojekt.helpers.NavigationItem
import com.example.bibleprojekt.ui.modules.bibleStories.BibleStoriesScreen
import com.example.bibleprojekt.ui.modules.bibleTrivia.BibleTriviaScreen
import com.example.bibleprojekt.ui.modules.home.HomeScreen
import com.example.bibleprojekt.ui.modules.lifeFileGuides.LifeFileGuidesScreen
import com.example.bibleprojekt.ui.modules.readingPlans.ReadingPlansScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun Navigation(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = NavigationItem.Home.route
    ) {
        composable(NavigationItem.Home.route) {
            HomeScreen(
                onClickViewLifeFileGuides = {
                    navController.navigateToRoute(
                        navController = navController,
                        route = NavigationItem.LifeFileGuides.route,
                    )
                },
                onClickViewBibleStories = {
                    navController.navigateToRoute(
                        navController = navController,
                        route = NavigationItem.BibleStories.route,
                    )
                },
                onClickViewBibleTrivia = {
                    navController.navigateToRoute(
                        navController = navController,
                        route = NavigationItem.BibleTrivia.route,
                    )
                },
                onClickViewReadingPlans = {
                    navController.navigateToRoute(
                        navController = navController,
                        route = NavigationItem.ReadingPlans.route,
                    )
                },
            )
        }
        composable(NavigationItem.LifeFileGuides.route) {
            LifeFileGuidesScreen()
        }
        composable(NavigationItem.BibleStories.route) {
            BibleStoriesScreen()
        }
        composable(NavigationItem.BibleTrivia.route) {
            BibleTriviaScreen()
        }
        composable(NavigationItem.ReadingPlans.route) {
            ReadingPlansScreen()
        }
    }
}

fun NavHostController.navigateToRoute(
    navController: NavController,
    route: String,
) = this.navigate(route) {
    navController.graph.startDestinationRoute?.let { route ->
        popUpTo(route) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}