package com.willyramad.notes

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.willyramad.notes.databinding.FragmentHomeBinding
import com.willyramad.notes.room.DataNote

class HomeFragment : Fragment() {
    lateinit var binding : FragmentHomeBinding
    lateinit var spH : SharedPreferences
     val viewModel : NoteViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        binding.Logout.setOnClickListener {
            logout()
        }
        viewModel.getNote().observe(viewLifecycleOwner){listNote->
            binding.rvNote.layoutManager = LinearLayoutManager(requireContext())
            binding.rvNote.adapter = NotesAdapter(requireContext(), listNote)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        spH = requireContext().getSharedPreferences("User",Context.MODE_PRIVATE)

        val user = spH.getString("Username","")
        binding.tvUsername.text = "Welcome $user"

        binding.btnAdd.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_addNoteFragment)
        }
    }

    fun logout (){
        spH.edit().clear()
        spH.edit().apply()
        findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
        Toast.makeText(context, "Anda berhasil Logout", Toast.LENGTH_SHORT).show()
    }
//    fun detail(view: View) {
//        adapter = NotesAdapter(requiredContext)
//        val lm = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
//        binding.rvNote.layoutManager = lm
//        binding.rvNote.adapter = adapter
//
//        adapter.onClick = {
//            var bundle = Bundle()
//            bundle.putSerializable("detail", it)
//            Navigation.findNavController(requireView())
//                .navigate(R.id.action_homeFragment_to_detailFragment)
//        }
//    }
}