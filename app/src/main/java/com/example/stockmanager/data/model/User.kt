package com.example.stockmanager.data.model

import com.salvation.diagnosis.model.Role

data class User(
    val id: String,
    val name: String,
    val email: String,
    val phone: String?,
    val token: String?,
    val description: String?,
    val roles: List<Role>
)