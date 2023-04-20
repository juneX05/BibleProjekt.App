package com.example.bibleprojekt.helpers

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavType
import androidx.navigation.navArgument

interface Destinations {
    val contentDescription: String?
    val title: String
    val icon: ImageVector
    val route: String
}

object Home : Destinations {
    override val route = "home"
    override val icon = Icons.Default.Home
    override val title = "Home"
    override val contentDescription = "Route to Home"
}
object LifeFileGuides : Destinations {
    override val route = "life_file_guides_root"
    override val icon = Icons.Default.ListAlt
    override val title = "Life File Guides Root"
     override val contentDescription = "Route to Life File Guides Root"
}
object ViewLifeFileGuides : Destinations {
    override val route = "life_file_guides"
    override val icon = Icons.Default.ListAlt
    override val title = "Life File Guides"
    override val contentDescription = "Route to View All Life File Guides"
}
object BibleStories : Destinations {
    override val route = "bible_stories"
    override val icon = Icons.Default.Book
    override val title = "Bible Stories"
    override val contentDescription = "Route to Bible Stories"
}
object BibleTrivia : Destinations {
    override val route = "bible_trivia"
    override val icon = Icons.Default.Quiz
    override val title = "Bible Trivia"
    override val contentDescription = "Route to Bible Trivia"
}
object ReadingPlans : Destinations {
    override val route = "reading_plans"
    override val icon = Icons.Default.MenuBook
    override val title = "Reading Plans"
    override val contentDescription = "Route to Reading Plans"
}
object LifeFileGuideDetails : Destinations {
    override val route = "reading_plans"
    override val icon = Icons.Default.Quiz
    override val title = ""
    const val titleArg = "title"
    const val subtitleArg = "subtitle"
    val routeWithArgs = "${route}/{${titleArg}}/{${subtitleArg}}"
    val arguments = listOf(
        navArgument(titleArg) {},
        navArgument(subtitleArg) {}
    )
    override val contentDescription = "Life file Guide Details"
}
