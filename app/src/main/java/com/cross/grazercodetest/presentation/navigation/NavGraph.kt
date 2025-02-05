package com.cross.grazercodetest.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cross.grazercodetest.presentation.login.LoginScreen
import com.cross.grazercodetest.presentation.userlist.UserListScreen
import com.cross.grazercodetest.presentation.userlist.UserListViewModel

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "login",
        modifier = modifier
    ) {
        composable("login") {
            LoginScreen(navController = navController)
        }

        composable("user_list") {
            val userListViewModel: UserListViewModel = hiltViewModel()
            UserListScreen(
                viewModel = userListViewModel,
                navController = navController
            )
        }
    }
}
