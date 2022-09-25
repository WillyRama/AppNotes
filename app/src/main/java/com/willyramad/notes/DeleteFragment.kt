package com.willyramad.notes

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.room.Update
import com.willyramad.notes.databinding.FragmentDeleteBinding
import com.willyramad.notes.room.NoteDatabase

class DeleteFragment : Fragment() {
    lateinit var binding: FragmentDeleteBinding
    val viewModel : NoteViewModel by viewModels()
    val dataNote by navArgs<DeleteFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDeleteBinding.inflate(inflater,container,false)

        binding.btnhapus.setOnClickListener {
            viewModel.deleteNote(dataNote.note.id)
            Navigation.findNavController(it).navigate(R.id.action_deleteFragment_to_homeFragment)
            Toast.makeText(context, "Data Berhasil Dihapus", Toast.LENGTH_SHORT).show()
        }
        binding.btnbatal.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_deleteFragment_to_homeFragment)
        }
        return binding.root
    }
}