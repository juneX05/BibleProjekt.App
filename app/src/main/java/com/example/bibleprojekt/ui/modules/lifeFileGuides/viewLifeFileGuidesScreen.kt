package com.example.bibleprojekt.ui.modules.lifeFileGuides

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bibleprojekt.helpers.DBHandler
import com.example.bibleprojekt.helpers.LifeFileGuide
import com.example.bibleprojekt.helpers.Section
import com.example.bibleprojekt.helpers.Story

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ViewLifeFileGuidesScreen(
    dbHandler: DBHandler,
    context: Context,
    onAddLifeFileGuideButtonClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val sections: MutableList<Section> = LifeFileGuide.all(context)

        val collapsed = remember(sections) {
            sections.map { true }.toMutableStateList()
        }
//        var isCollapsed by remember { mutableStateOf(true) } // State for section collapsed state

        var previousClickedIndex = -1
        LazyColumn(reverseLayout = false, contentPadding = PaddingValues(6.dp)) {

            sections.forEachIndexed { index, section ->
                val isCollapsed = collapsed[index]
                stickyHeader {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                            .padding(16.dp)
                            .clickable {
                                if (previousClickedIndex > -1)
                                    collapsed[previousClickedIndex] = true
                                previousClickedIndex = index;
                                collapsed[index] = !isCollapsed
                            },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = section.title,
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            ),
                            modifier = Modifier.weight(1f)
                        )

                        if (isCollapsed) {
                            Icon(
                                imageVector = Icons.Filled.ArrowDropDown,
                                contentDescription = "Expand Section"
                            )
                        } else {

                            Icon(
                                imageVector = Icons.Filled.ArrowDropUp,
                                contentDescription = "Collapse Section"
                            )
                        }

                    }
                }

                items(section.stories.size) { position ->
                    val story: Story = section.stories[position]
                    if (!isCollapsed) {
                        Text(
                            text = story.subtitle,
                            style = TextStyle(
                                fontSize = 16.sp,
                                color = Color.Blue
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.White)
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                                .clickable {
                                    // navigateToDetailScreen(story)
                                }
                        )
                    }
                }
            }
        }

    }
}
