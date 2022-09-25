package com.willyramad.notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.room.Update
import com.willyramad.notes.databinding.FragmentEditBinding
import com.willyramad.notes.room.DataNote

class EditFragment : Fragment() {
    lateinit var binding : FragmentEditBinding
    val viewModel : NoteViewModel by viewModels()
    val dataNote by navArgs<EditFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      binding = FragmentEditBinding.inflate(layoutInflater,container,false)
        binding.noteTitle.setText(dataNote.note.tittle)
        binding.NoteContent.setText(dataNote.note.content)
        binding.btnsave.setOnClickListener {
            editNote()

        }
        return binding.root
    }
    fun editNote(){
        var title = binding.noteTitle.text.toString()
        var content = binding.NoteContent.text.toString()
        val note = DataNote(dataNote.note.id,title,content)
        viewModel.updateNote(note)
        findNavController().navigate(R.id.action_editFragment_to_homeFragment)
        Toast.makeText(context, "Edit Note Berhasil", Toast.LENGTH_SHORT).show()
    }
}