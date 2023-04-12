package com.example.bibleprojekt.ui.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.bibleprojekt.helpers.NavigationItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun DrawerHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        val imageID: Int = if (isSystemInDarkTheme()) {
            com.example.bibleprojekt.R.drawable.logo_light;
        } else {
            com.example.bibleprojekt.R.drawable.logo_dark;
        }

        Image(
            painter = painterResource(id = imageID),
            contentDescription = "logo",
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .padding(10.dp)
        )
    }
}

@Composable
fun Drawer(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    navController: NavController
) {

    Column {
        DrawerHeader()
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .weight(weight = 1f, fill = true)
        ) {


            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(5.dp)
            )

            Divider()
            DrawerBody(
                scope = scope,
                scaffoldState = scaffoldState,
                navController = navController
            )

            Spacer(modifier = Modifier.weight(1f))

            Divider()
            Text(
                fontSize = 10.sp,
                text = "JuneX05 was here.",
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.6f),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(10.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }

    }



}

@Composable
fun DrawerBody(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    navController: NavController
) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.LifeFileGuides,
        NavigationItem.BibleStories,
        NavigationItem.BibleTrivia,
        NavigationItem.ReadingPlans,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

//    LazyColumn() {
//        items(items.size) { position ->
    items.forEach { item ->
        DrawerItem(
            item = item,
            selected = currentRoute == item.route,
            onItemClick = {
                navController.navigate(item.route) {
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }

                    scope.launch { scaffoldState.drawerState.close() }
                }
            }
        )
    }

//        }
//    }
}
