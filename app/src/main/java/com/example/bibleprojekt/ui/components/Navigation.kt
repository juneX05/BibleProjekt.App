package com.example.bibleprojekt.ui.components

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.bibleprojekt.helpers.*
import com.example.bibleprojekt.ui.modules.bibleStories.BibleStoriesScreen
import com.example.bibleprojekt.ui.modules.bibleTrivia.BibleTriviaScreen
import com.example.bibleprojekt.ui.modules.home.HomeScreen
import com.example.bibleprojekt.ui.modules.lifeFileGuides.LifeFileGuideDetailsScreen
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
        startDestination = Home.route
    ) {
        composable(Home.route) {
            HomeScreen(
                onClickViewLifeFileGuides = {
                    navController.navigateToRoute(
                        navController = navController,
                        route = LifeFileGuides.route,
                    )
                },
                onClickViewBibleStories = {
                    navController.navigateToRoute(
                        navController = navController,
                        route = BibleStories.route,
                    )
                },
                onClickViewBibleTrivia = {
                    navController.navigateToRoute(
                        navController = navController,
                        route = BibleTrivia.route,
                    )
                },
                onClickViewReadingPlans = {
                    navController.navigateToRoute(
                        navController = navController,
                        route = ReadingPlans.route,
                    )
                },
            )
        }
        composable(BibleStories.route) {
            BibleStoriesScreen()
        }
        composable(BibleTrivia.route) {
            BibleTriviaScreen()
        }
        composable(ReadingPlans.route) {
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
        startDestination = ViewLifeFileGuides.route,
        route = LifeFileGuides.route
    ) {

        composable(ViewLifeFileGuides.route) {
            ViewLifeFileGuidesScreen(
                dbHandler = dbHandler,
                context = LocalContext.current.applicationContext,
                onLifeFileGuideTitleClick = { story ->
                    navController.navigate(
                        route = "${LifeFileGuideDetails.route}/${story.title}/${story.subtitle}",
                    ) {
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(
            route = LifeFileGuideDetails.routeWithArgs,
            arguments = LifeFileGuideDetails.arguments
        ) { navBackStackEntry ->
            val title = navBackStackEntry.arguments?.getString(LifeFileGuideDetails.titleArg)
            val subtitle = navBackStackEntry.arguments?.getString(LifeFileGuideDetails.subtitleArg)

            if (title != null && subtitle != null) {
                LifeFileGuideDetailsScreen(
                    title, subtitle
                )
            }
        }

    }
}