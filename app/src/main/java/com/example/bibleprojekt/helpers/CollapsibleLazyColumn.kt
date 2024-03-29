package com.example.bibleprojekt.helpers

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

data class CollapsibleSection(
    val title: String,
    val rows: List<String>
);

@Composable
fun CollapsibleLazyColumn(
    sections: List<CollapsibleSection>,
    modifier: Modifier = Modifier
) {
    val collapsedState = remember(sections) {
        sections.map { true }.toMutableStateList()
    }

    var previousClickedIndex = -1

    LazyColumn(modifier) {
        sections.forEachIndexed { i, dataItem ->
            val collapsed = collapsedState[i]
            item(key = "header_$i") {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable {
                        if (previousClickedIndex > -1)
                            collapsedState[previousClickedIndex] = true
                        previousClickedIndex = i;
                        collapsedState[i] = !collapsed
                    }
                ) {
                    Icon(
                        Icons.Default.run {
                            if (collapsed) KeyboardArrowDown
                            else KeyboardArrowUp
                        },
                        contentDescription = "Collapsible Icon",
                        tint = Color.LightGray
                    )

                    Text(
                        text = dataItem.title,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                            .weight(1f)
                    )
                }
                Divider()
            }

            if (!collapsed) {
                items(dataItem.rows.size) { position ->
                    Row {
                        Spacer(modifier = Modifier.size(MaterialIconDimension.dp))
                        Text(
                            dataItem.rows[position],
                            modifier = Modifier.padding(vertical = 10.dp)
                        )
                    }
                    Divider()
                }
            }
        }
    }
}


const val MaterialIconDimension = 24f