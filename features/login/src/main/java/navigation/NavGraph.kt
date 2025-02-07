package navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import navigation.NavDestinations.LoginScreen
import navigation.NavDestinations.UserListScreen
import presentation.LoginScreen
import presentation.UserListScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = LoginScreen.route
    ) {
        composable(LoginScreen.route) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(UserListScreen.route) {
                        popUpTo(LoginScreen.route) { inclusive = true }
                    }
                }
            )
        }
        composable(UserListScreen.route) {
            UserListScreen()
        }
    }
}
