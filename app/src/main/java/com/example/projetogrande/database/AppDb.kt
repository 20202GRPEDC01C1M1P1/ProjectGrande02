package com.example.projetogrande.database

import android.content.Context
import androidx.room.Room

object AppDb {
    private var db: RoomDatabase? = null
    fun getInstance(context: Context): RoomDatabase {
        if (db == null) {
            db = Room
                .databaseBuilder(
                    context,
                    RoomDatabase::class.java,
                    "dbApp"
                )
                .allowMainThreadQueries()
                .build()
        }
        return db as RoomDatabase
    }
}