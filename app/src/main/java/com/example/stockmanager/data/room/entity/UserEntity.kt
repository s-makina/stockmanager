package com.example.stockmanager.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_user")
data class UserEntity(
    @PrimaryKey
    val id: String
)