package com.willyramad.notes

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.willyramad.notes.databinding.FragmentDeleteBinding
import com.willyramad.notes.databinding.FragmentDetailBinding
import com.willyramad.notes.room.DataNote

class DetailFragment : Fragment() {
    lateinit var binding : FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(layoutInflater,container,false)
        return binding.root

        var ambildetail = arguments?.getSerializable("detail") as DataNote
        binding.data
    }
}