package com.example.bibleprojekt.ui.modules.lifeFileGuides

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bibleprojekt.helpers.CollapsibleLazyColumn
import com.example.bibleprojekt.helpers.CollapsibleSection
import com.example.bibleprojekt.helpers.DBHandler
import com.example.bibleprojekt.helpers.LifeFileGuide

@Composable
fun ViewLifeFileGuidesScreen(
    dbHandler: DBHandler,
    onAddLifeFileGuideButtonClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = onAddLifeFileGuideButtonClick) {
            Text(text = "Add Life File Guide")
        }

        val readableDB = dbHandler.readableDatabase
        Text(text = LifeFileGuide.all(readableDB).toString())

        CollapsibleLazyColumn(
            sections = listOf(
                CollapsibleSection(
                    title = "Fruits A",
                    rows = listOf("Apple", "Apricots", "Avocado")
                ),
                CollapsibleSection(
                    title = "Fruits B",
                    rows = listOf("Banana", "Blackberries", "Blueberries")
                ),
                CollapsibleSection(
                    title = "Fruits C",
                    rows = listOf("Cherimoya", "Cantaloupe", "Cherries", "Clementine")
                ),
            ),
        )

    }
}


