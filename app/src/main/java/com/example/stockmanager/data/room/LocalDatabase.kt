package com.example.stockmanager.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.stockmanager.data.room.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
@TypeConverters(Convertors::class)
abstract class LocalDatabase : RoomDatabase() {
//    abstract fun inputsDao(): InputsDao
//    abstract fun patientDao(): PatientDao

    companion object {
        @Volatile
        private var INSTANCE : LocalDatabase? = null

        fun getInstance(context : Context) : LocalDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    LocalDatabase::class.java,
                    "stockmanager_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}