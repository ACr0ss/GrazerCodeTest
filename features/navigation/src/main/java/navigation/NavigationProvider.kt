package navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

interface NavigationProvider {
    @Composable
    fun NavGraph(navController: NavHostController)
}