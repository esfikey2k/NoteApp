package com.example.noteapp.view.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DELETED_NOTE")
data class DeletedNote(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "deleted_note_id")
    val deletedNoteId: Int= 0,

    @ColumnInfo(name = "deleted_note_title")
    val deletedNoteTitle: String,

    @ColumnInfo(name = "deleted_note_description")
    val deletedNoteDescription: String,

    @ColumnInfo(name = "deleted_note_date")
    val deletedNoteDate: String
)
