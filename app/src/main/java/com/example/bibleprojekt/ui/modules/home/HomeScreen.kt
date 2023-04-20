package com.example.bibleprojekt.ui.modules.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Sort
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bibleprojekt.ui.components.AlertDialogComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.*

@Composable
fun HomeScreen(
    onClickViewLifeFileGuides: () -> Unit = {},
    onClickViewBibleStories: () -> Unit = {},
    onClickViewBibleTrivia: () -> Unit = {},
    onClickViewReadingPlans: () -> Unit = {},
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Home",
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.onBackground,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
            .verticalScroll(rememberScrollState())
                .semantics { contentDescription = "Home Screen" },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onClickViewLifeFileGuides) {
                Text(text = "Go to Life File Guides")
            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onClickViewBibleStories) {
                Text(text = "Go to Bible Stories")
            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onClickViewBibleTrivia) {
                Text(text = "Go to Bible Trivia")
            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onClickViewReadingPlans) {
                Text(text = "Go to Reading Plans")
            }

//            Card(
//                elevation = 12.dp,
//            ) {
//
//            }

//            AlertCard()

        }
    }
}

@Composable
private fun AlertCard() {
    var showDialog by remember { mutableStateOf(false) }
    val alertMessage = "This is a demo alert"

    if (showDialog) {
        AlertDialogComponent(
            onDismiss = { showDialog = false },
            bodyText = alertMessage,
            buttonText = "Dismiss".uppercase(Locale.getDefault())
        )
    }
    Card {
        Column {
            AlertHeader {
                showDialog = true
            }

            Divider(
                color = MaterialTheme.colors.background,
                thickness = 1.dp,
                modifier = Modifier
                    .padding(start = 12.dp, end = 12.dp)
            )

            AlertItem(alertMessage)
        }
    }
}

@Composable
private fun AlertHeader(
    onClickSeeAll: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Alerts",
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        TextButton(
            onClick = onClickSeeAll,
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            Text(text = "SEE ALL", style = MaterialTheme.typography.button)
        }
    }
}

@Composable
private fun AlertItem(
    message: String
) {
    Row(
        modifier = Modifier
            .padding(12.dp)
            .semantics(mergeDescendants = true) {},
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = message, style = MaterialTheme.typography.body2, modifier = Modifier.weight(1f))
        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .align(Alignment.Top)
                .clearAndSetSemantics {}
        ) {
            Icon(imageVector = Icons.Filled.Sort, contentDescription = null)
        }
    }
}