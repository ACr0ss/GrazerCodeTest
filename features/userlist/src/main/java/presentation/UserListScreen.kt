package presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.cross.grazercodetest.presentation.theme.GrazerCodeTestTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import model.User
import presentation.components.UserCard

@Composable
fun UserListScreen(
    navController: NavController,
    viewModel: UserListViewModel = viewModel()
) {
    val systemUiController = rememberSystemUiController()
    val statusBarColor = MaterialTheme.colorScheme.surface
    val users by viewModel.users.collectAsState(initial = null)

    SideEffect {
        systemUiController.setStatusBarColor(statusBarColor)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        users?.let { nonNullUsers ->
            UserListContent(users = nonNullUsers, viewModel = viewModel)
        } ?: run {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
    }
}

@Composable
fun UserListContent(
    users: List<User>,
    viewModel: UserListViewModel
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(users) { user ->
            UserCard(user = user, viewModel = viewModel)
        }
    }
}

@Composable
private fun UserCard(user: User, viewModel: UserListViewModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            var isImageLoaded by remember { mutableStateOf(true) }
            Box(
                modifier = Modifier
                    .size(60.dp)
            ) {
                if (isImageLoaded) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(user.profileImage)
                            .crossfade(true)
                            .memoryCacheKey(user.profileImage)
                            .diskCacheKey(user.profileImage)
                            .build(),
                        contentDescription = "Profile picture of ${user.name}",
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop,
                        onError = {
                            isImageLoaded = false
                        }
                    )
                } else {
                    InitialsAvatar(name = user.name)
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(text = user.name)
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "DOB: ${viewModel.formatDate(user.dateOfBirth)}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
private fun InitialsAvatar(name: String) {
    Box(
        modifier = Modifier
            .size(60.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = name.split(" ")
                .take(2)
                .map { it.first() }
                .joinToString(""),
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.titleMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun UserListScreenPreview() {
    GrazerCodeTestTheme {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(2) { index ->
                when (index) {
                    0 -> UserCardPreview(
                        name = "John Doe",
                        dateOfBirth = "Jan 01, 2001"
                    )
                    1 -> UserCardPreview(
                        name = "Jane Smith",
                        dateOfBirth = "Dec 31, 2000"
                    )
                }
            }
        }
    }
}

@Composable
private fun UserCardPreview(
    name: String,
    dateOfBirth: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            InitialsAvatar(name = name)

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(text = name)
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "DOB: $dateOfBirth",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
