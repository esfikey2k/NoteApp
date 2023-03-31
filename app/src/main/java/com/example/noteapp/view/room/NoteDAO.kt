package com.example.noteapp.view.room


import androidx.room.*

@Dao
interface NoteDAO {

    @Query("SELECT * FROM NOTE")
    fun getAll(): List<Note>

    @Query("SELECT * FROM NOTE WHERE note_id = :id")
    fun getById(id: Int): List<Note>

    @Insert
    fun insert(note: Note)

    @Delete
    fun delete(note: Note)

    @Update
    fun update(note: Note)

    @Query("SELECT * FROM DELETED_NOTE")
    fun getAllDeleted(): List<DeletedNote>
    @Insert
    fun deletedInsert(note: DeletedNote)

    @Delete
    fun deletedDelete(note: DeletedNote)



}