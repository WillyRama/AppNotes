package com.willyramad.notes

import androidx.lifecycle.LiveData
import com.willyramad.notes.room.DataNote
import com.willyramad.notes.room.NoteDao

class NoteRepo(val dao : NoteDao) {

    fun getAllNote(): LiveData<List<DataNote>> {
        return dao.getDataNote()
    }
    fun insertNote(note : DataNote){
        dao.insertNote(note)
    }
    fun deleteNote(id : Int){
        dao.deleteNote(id)
    }
    fun updateNote(note : DataNote){
        dao.updateNote(note)
    }

}