package com.willyramad.notes

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.willyramad.notes.databinding.FragmentAddNoteBinding
import com.willyramad.notes.room.DataNote
import com.willyramad.notes.room.NoteDatabase

class AddNoteFragment : Fragment() {
    lateinit var binding : FragmentAddNoteBinding
    val viewModel : NoteViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding = FragmentAddNoteBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnsave.setOnClickListener {
            AddNote()
        }
    }
    fun AddNote(){
        var judul = binding.noteTitle.text.toString()
        var konten =  binding.NoteContent.text.toString()
        val Notes = DataNote(0,judul,content = konten)
        viewModel.addNote(Notes)
        findNavController().navigate(R.id.action_addNoteFragment_to_homeFragment)
    }
}