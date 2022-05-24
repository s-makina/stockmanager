package com.example.stockmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.example.stockmanager.Config.Companion.isDarkTheme
import com.example.stockmanager.Config.Companion.processing
import com.example.stockmanager.ui.dialog.ProcessLoader
import com.example.stockmanager.ui.navigation.Navigation
import com.example.stockmanager.ui.theme.AppTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme(useDarkTheme = isDarkTheme.value) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val permissionGranted = remember{ mutableStateOf(false) }
                    SystemBar()
                    Permissions(permissionGranted)
                    if (permissionGranted.value) {
                        Navigation()
                    }
                    ProcessLoader(processing)
                }
            }
        }
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun Permissions(permissionGranted: MutableState<Boolean>) {
    val multiPermissionState = rememberMultiplePermissionsState(
        permissions = listOf(
//            Manifest.permission.WRITE_EXTERNAL_STORAGE,
//            Manifest.permission.READ_EXTERNAL_STORAGE,
        )
    )

    val lifecycleOwner = LocalLifecycleOwner.current

    DisposableEffect(key1 = lifecycleOwner, effect = {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_START -> {
                    multiPermissionState.launchMultiplePermissionRequest()
                }
                else -> Unit
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    })

    if( multiPermissionState.allPermissionsGranted ) {
        permissionGranted.value = true
    }
}

@Composable
fun SystemBar() {
    // Remember a SystemUiController
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = isDarkTheme.value
    val color = MaterialTheme.colorScheme.onSurface

    SideEffect {
        // Update all of the system bar colors to be transparent, and use
        // dark icons if we're in light theme
        systemUiController.setSystemBarsColor(
            color = color,
            darkIcons = useDarkIcons
        )
        // setStatusBarsColor() and setNavigationBarColor() also exist
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppTheme(useDarkTheme = isDarkTheme.value) {
        Navigation()
    }
}

