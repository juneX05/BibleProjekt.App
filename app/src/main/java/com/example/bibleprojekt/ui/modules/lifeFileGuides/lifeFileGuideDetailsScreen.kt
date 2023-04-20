package com.example.bibleprojekt.ui.modules.lifeFileGuides

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bibleprojekt.helpers.LifeFileGuide
import com.example.bibleprojekt.helpers.Story

@Composable
fun LifeFileGuideDetailsScreen(
    title: String,
    subtitle: String
) {
    val context =  LocalContext.current.applicationContext
    val story = remember(subtitle) { LifeFileGuide.getStory(
        context , title, subtitle
    ) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = story.subtitle,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onBackground,
                fontSize = 15.sp,
                textAlign = TextAlign.Center
            )

            Text(
                text = story.title,
                color = MaterialTheme.colors.onBackground,
                fontSize = 13.sp,
                textAlign = TextAlign.Center
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
                    .semantics { contentDescription = "Life File Guides Screen" },
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                Text(text = story.story)

            }
        }

    }
}