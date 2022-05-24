package com.example.stockmanager

import androidx.compose.runtime.mutableStateOf

class Config {
    companion object {
        const val API_ADDRESS = "http://54.144.231.44:90/api/"
        val isDarkTheme = mutableStateOf(false)
        val processing = mutableStateOf(false)
    }
}