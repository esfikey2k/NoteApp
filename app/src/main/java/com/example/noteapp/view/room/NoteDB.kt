package com.example.noteapp.view.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//@Database(entities = [Note::class], version = 1)
//abstract class NoteDB: RoomDatabase() {
//
//    abstract val noteDao: NoteDAO
//
//    companion object{
//        private var INSTANCE: NoteDB? = null
//
//        fun getInstance(context: Context): NoteDB{
//
//            return INSTANCE ?: Room.databaseBuilder(
//                context,
//                NoteDB::class.java,
//                "note_db"
//            ).allowMainThreadQueries()
//                .build().also {
//                    INSTANCE= it
//                }
//
//        }
//    }
//
//}