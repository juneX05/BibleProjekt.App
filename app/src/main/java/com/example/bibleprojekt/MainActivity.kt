package com.example.bibleprojekt

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController
import com.example.bibleprojekt.helpers.DBHandler
import com.example.bibleprojekt.ui.components.Drawer
import com.example.bibleprojekt.ui.components.Navigation
import com.example.bibleprojekt.ui.components.TopBar
import com.example.bibleprojekt.ui.theme.BibleProjektTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BibleProjektTheme {
                val scaffoldState = rememberScaffoldState(
                    rememberDrawerState(initialValue = DrawerValue.Closed)
                )
                val scope = rememberCoroutineScope()
                val navController = rememberNavController()

                val dbHandler = DBHandler(applicationContext)

                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        TopBar(scope = scope, scaffoldState = scaffoldState)
                    },
                    drawerContent = {
                        Drawer(
                            scope = scope,
                            scaffoldState = scaffoldState,
                            navController = navController
                        )
                    }
                ) {
                    Navigation(
                        dbHandler = dbHandler,
                        navController = navController
                    )
                }
            }
        }
    }
}
