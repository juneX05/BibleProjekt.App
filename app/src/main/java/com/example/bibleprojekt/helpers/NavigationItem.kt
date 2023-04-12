package com.example.bibleprojekt.helpers

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(
    var route: String,
    var icon: ImageVector,
    var title: String,
    var contentDescription: String
) {
    object Home : NavigationItem(
        route = "home",
        icon = Icons.Default.Home,
        title = "Home",
        contentDescription = "Route to Home"
    )

    object LifeFileGuides : NavigationItem(
        route = "life_file_guides",
        icon = Icons.Default.ListAlt,
        title = "Life File Guides",
        contentDescription = "Route to Life File Guides"
    )

    object BibleStories : NavigationItem(
        route = "bible_stories",
        icon = Icons.Default.Book,
        title = "Bible Stories",
        contentDescription = "Route to Bible Stories"
    )

    object BibleTrivia : NavigationItem(
        route = "bible_trivia",
        icon = Icons.Default.Quiz,
        title = "Bible Trivia",
        contentDescription = "Route to Bible Trivia"
    )

    object ReadingPlans : NavigationItem(
        route = "reading_plans",
        icon = Icons.Default.MenuBook,
        title = "Reading Plans",
        contentDescription = "Route to Reading Plans"
    )

}
