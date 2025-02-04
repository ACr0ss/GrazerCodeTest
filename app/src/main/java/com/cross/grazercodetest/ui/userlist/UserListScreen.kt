package com.cross.grazercodetest.ui.userlist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.cross.grazercodetest.data.models.User
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun UserListScreen(navController: NavController, viewModel: UserListViewModel) {
    val viewModel: UserListViewModel = viewModel()
    val users by viewModel.users.collectAsState()

    if (users != null) {
        UserListContent(users = users!!)
    } else {
        // Display a loading indicator or placeholder
    }
}

@Composable
fun UserListContent(users: List<User>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(users) { user ->
            UserCard(user = user)
        }
    }
}

@Composable
private fun UserCard(user: User) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(text = user.name)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "DOB: ${user.date_of_birth}")
            // You can add an AsyncImage here for profile_image if needed
        }
    }
}
