package com.willyramad.notes.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note : DataNote)

    @Query("SELECT * FROM DataNote ORDER BY id DESC ")
    fun getDataNote(): LiveData<List<DataNote>>

    @Query("DELETE FROM DataNote WHERE id=:id")
    fun deleteNote(id: Int) : Int

    @Update
    fun updateNote(note : DataNote)
}