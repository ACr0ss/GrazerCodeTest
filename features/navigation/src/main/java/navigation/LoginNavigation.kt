package navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import navigation.NavDestinations.UserListScreen
import presentation.LoginScreen

class LoginNav : NavigationProvider {
    @Composable
    override fun NavGraph(navController: NavHostController) {
        NavHost(
            navController = navController,
            startDestination = NavDestinations.LoginScreen.route
        ) {
            composable(NavDestinations.LoginScreen.route) {
                LoginScreen(
                    onLoginSuccess = {
                        navController.navigate(UserListScreen.route) {
                            popUpTo(NavDestinations.LoginScreen.route) { inclusive = true }
                        }
                    }
                )
            }
            composable(UserListScreen.route) {
                UserListScreen()
            }
        }
    }
}