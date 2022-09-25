package com.willyramad.notes

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.willyramad.notes.databinding.ItemNoteBinding
import com.willyramad.notes.room.DataNote

class NotesAdapter(val requiredContext: Context, val listNote : List<DataNote>): RecyclerView.Adapter<NotesAdapter.ViewHolder>() {
    var onClick : ((DataNote) -> Unit)? = null
    class ViewHolder(var binding : ItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {
        fun dataNote(data : DataNote){
            binding.data = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemNoteBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.dataNote(listNote[position])
        holder.binding.btnDelete.setOnClickListener {
            val hapus = HomeFragmentDirections.actionHomeFragmentToDeleteFragment(listNote[position])
            Navigation.findNavController(it).navigate(hapus)
        }
        holder.binding.btnEdit.setOnClickListener {
            val edit = HomeFragmentDirections.actionHomeFragmentToEditFragment(listNote[position])
            Navigation.findNavController(it).navigate(edit)
        }
//        holder.binding.noteKlik.setOnClickListener {
//            val detail = HomeFragmentDirections.actionHomeFragmentToDetailFragment()
//            Navigation.findNavController(it).navigate(detail)
//        }
    }

    override fun getItemCount(): Int {
        return listNote.size
    }
}