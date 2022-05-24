package com.example.stockmanager.ui.dialog

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties

@Composable
fun Alert(
    showDialog: MutableState<Boolean> = mutableStateOf(true),
    title: String,
    content: String,
    alertType: AlertType
) {
    val icon = when (alertType) {
        AlertType.ERROR -> Icons.Default.Error
        AlertType.INFO -> Icons.Default.Info
        AlertType.SUCCESS -> Icons.Default.Check
    }

    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            dismissButton = {
                TextButton(onClick = { showDialog.value = false }) {
                    Text(text = "Close")
                }
            },
            properties = DialogProperties(),
            title = { Text(text = title) },
            text = {
                Text(
                    text = content,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            },
            icon = {
                Icon(
                    imageVector = icon,
                    contentDescription = "",
                    modifier = Modifier.size(40.dp)
                )
            },
            confirmButton = {}
        )
    }
}

enum class AlertType {
    ERROR,
    SUCCESS,
    INFO
}
