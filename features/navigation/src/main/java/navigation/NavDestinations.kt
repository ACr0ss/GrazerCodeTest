package navigation

sealed class NavDestinations(val route: String) {
    object LoginScreen : NavDestinations("login")
    object UserListScreen : NavDestinations("userList")
}