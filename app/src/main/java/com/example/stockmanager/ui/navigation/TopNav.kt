package com.example.stockmanager.ui.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.stockmanager.Config.Companion.isDarkTheme
import com.example.stockmanager.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNav(title: String, navController: NavHostController, backButton: Boolean = false) {
    SmallTopAppBar(
        title = {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(text = title, maxLines = 1, overflow = TextOverflow.Ellipsis)
//                val name = authUser.value?.name ?: ""
//                Text(
//                    text = name,
//                    maxLines = 1,
//                    overflow = TextOverflow.Ellipsis,
//                    style = MaterialTheme.typography.labelMedium
//                )
            }
        },
        navigationIcon = {
            Row(
                modifier = Modifier.fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (backButton) {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back Button"
                        )
                    }
                }
//                Icon(
//                    painter = painterResource(id = androidx.media2.R.drawable.ic_music_note),
//                    contentDescription = "",
//                    tint = MaterialTheme.colorScheme.primary,
//                    modifier = Modifier.padding(start = 8.dp, end = 8.dp)
////                    modifier = Modifier.size(height = 28.302.dp, width = 60.dp)
//                )
            }
        },
        actions = {
            IconButton(onClick = {
                isDarkTheme.value = !isDarkTheme.value
            }) {
                val icon =
                    if (isDarkTheme.value) Icons.Default.LightMode else Icons.Default.DarkMode
                Icon(
                    imageVector = icon,
                    contentDescription = null
                )
            }

            val expanded = remember { mutableStateOf(false) }

            IconButton(onClick = { expanded.value = true }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "More Button"
                )
                MenuDropDown(expanded = expanded, onClick = {
                    if (it == "logout") {
                        navController.navigate(Screen.LoginPage.route) {
                            popUpTo(Screen.LoginPage.route)
                        }
                    } else {
                        navController.navigate(it) {
                            launchSingleTop = true
                        }
                    }
                })
            }
        },
    )
}

@Composable
fun Logo() {
    Icon(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "",
        tint = MaterialTheme.colorScheme.primary
    )
}

@Composable
fun DialogHeader(title: String, onCLose: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Logo()
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.weight(1f)
        )
        IconButton(onClick = { onCLose() }) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "")
        }
    }
}

@Composable
fun MenuDropDown(expanded: MutableState<Boolean>, onClick: (String) -> Unit = {}) {
    DropdownMenu(expanded = expanded.value, onDismissRequest = { expanded.value = false }) {
        DropdownMenuItem(
            text = { Text("Patients") },
            onClick = {
                expanded.value = false
//                onClick(Screen.Patients.route)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = ""
                )
            })

        DropdownMenuItem(
            text = { Text("Settings") },
            onClick = {
                expanded.value = false
//                onClick(Screen.SettingsPage.route)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = ""
                )
            })

        DropdownMenuItem(
            text = { Text("Logout") },
            onClick = {
                expanded.value = false
                onClick("logout")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Logout,
                    contentDescription = ""
                )
            })
    }
}