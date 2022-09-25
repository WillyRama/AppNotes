package com.willyramad.notes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.willyramad.notes.room.DataNote
import com.willyramad.notes.room.NoteDatabase

class NoteViewModel(app : Application) : AndroidViewModel(app) {
    val repository : NoteRepo
    init {
        val dao = NoteDatabase.getInstance(app)!!.noteDao()
        repository = NoteRepo(dao)
    }

    fun addNote(note : DataNote) {
        repository.insertNote(note)
    }

    fun getNote(): LiveData<List<DataNote>> = repository.getAllNote()

    fun deleteNote(id : Int) {
        repository.deleteNote(id)
    }

    fun updateNote(note : DataNote) {
        repository.updateNote(note)
    }
}