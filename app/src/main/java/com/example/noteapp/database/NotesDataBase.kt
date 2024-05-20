package com.example.noteapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NotesData::class], version = 1)
abstract class NotesDataBase() : RoomDatabase() {
    abstract fun getNotesDao(): NotesDao

    companion object {
        fun dataBaseBuilder(context: Context) =
            Room.databaseBuilder(
                context.applicationContext, NotesDataBase::class.java, "notes.db"
            )
                .allowMainThreadQueries()
                .build()
    }


}