package com.cross.grazercodetest.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.cross.grazercodetest.presentation.theme.GrazerCodeTestTheme
import dagger.hilt.android.AndroidEntryPoint
import navigation.LoginNav

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GrazerCodeTestTheme {
                val navController = rememberNavController()
                val navigationProvider = LoginNav()
                navigationProvider.NavGraph(navController)
            }
        }
    }
}