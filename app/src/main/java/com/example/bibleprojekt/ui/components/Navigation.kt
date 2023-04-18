package com.example.bibleprojekt.ui.components

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.bibleprojekt.helpers.DBHandler
import com.example.bibleprojekt.helpers.NavigationItem
import com.example.bibleprojekt.ui.modules.bibleStories.BibleStoriesScreen
import com.example.bibleprojekt.ui.modules.bibleTrivia.BibleTriviaScreen
import com.example.bibleprojekt.ui.modules.home.HomeScreen
import com.example.bibleprojekt.ui.modules.lifeFileGuides.CreateLifeFileGuidesScreen
import com.example.bibleprojekt.ui.modules.lifeFileGuides.LifeFileGuidesScreen
import com.example.bibleprojekt.ui.modules.lifeFileGuides.ViewLifeFileGuidesScreen
import com.example.bibleprojekt.ui.modules.readingPlans.ReadingPlansScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun Navigation(
    dbHandler: DBHandler,
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
        composable(NavigationItem.BibleStories.route) {
            BibleStoriesScreen()
        }
        composable(NavigationItem.BibleTrivia.route) {
            BibleTriviaScreen()
        }
        composable(NavigationItem.ReadingPlans.route) {
            ReadingPlansScreen()
        }

        lifeFileGuideRoutes(dbHandler = dbHandler, navController = navController)
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

fun NavGraphBuilder.lifeFileGuideRoutes(
    dbHandler: DBHandler,
    navController: NavHostController
) {
    navigation(
        startDestination = NavigationItem.ViewLifeFileGuides.route,
        route = NavigationItem.LifeFileGuides.route
    ) {

        composable(NavigationItem.ViewLifeFileGuides.route) {
            ViewLifeFileGuidesScreen(
                dbHandler = dbHandler,
                onAddLifeFileGuideButtonClick = {
                    navController.navigateToRoute(
                        navController = navController,
                        route = NavigationItem.CreateLifeFileGuides.route,
                    )
                }
            )
        }

        composable(NavigationItem.CreateLifeFileGuides.route) {
            CreateLifeFileGuidesScreen()
        }

    }
}