package com.example.bibleprojekt.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bibleprojekt.helpers.Destinations

@Composable
fun DrawerItem(
    title: String,
    icon: ImageVector,
    selected: Boolean,
    onItemClick: () -> Unit
) {
    val background: Color;
    val color: Color;
     if (selected) {
         background = MaterialTheme.colors.primary
         color = MaterialTheme.colors.onPrimary
     } else {
         background = Color.Unspecified
         color = MaterialTheme.colors.onBackground
     }

    Row(verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier
        .fillMaxWidth()
        .clickable { onItemClick() }
        .height(45.dp)
        .background(background)
        .padding(start = 10.dp)) {
        
        Image(
            imageVector = icon,
            contentDescription = "$",
            colorFilter = ColorFilter.tint(color),
            modifier = Modifier
                .height(24.dp)
                .width(24.dp)
        )
        
        Spacer(modifier = Modifier.width(10.dp))

        Text(text = title, fontSize = 16.sp, color = color)

    }
    Divider()

}