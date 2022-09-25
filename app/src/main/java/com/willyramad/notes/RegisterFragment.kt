package com.willyramad.notes

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.willyramad.notes.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    lateinit var binding : FragmentRegisterBinding
    lateinit var spr : SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        spr = requireContext().getSharedPreferences("User", Context.MODE_PRIVATE)
        binding.btnRegis.setOnClickListener {
            Regis()
        }
        binding.backLogin.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }
    fun Regis(){
        var Username = binding.edUsername.text.toString()
        var Password = binding.edPassword.text.toString()
        var Email = binding.edEmail.text.toString()
        var konfirm = binding.edKonfirmPassword.text.toString()
        var eduser = spr.edit()
        eduser.putString("Username", Username)
        eduser.putString("Password", Password)
        eduser.putString("Email", Email)
        eduser.putString("konfirm", konfirm)
        if (Password == konfirm){
            eduser.apply()
            Toast.makeText(context, "Registrasi Anda Telah Berhasil", Toast.LENGTH_SHORT).show()
            binding.edEmail.setText("")
            binding.edPassword.setText("")
            binding.edUsername.setText("")
            binding.edKonfirmPassword.setText("")
        }else{
            Toast.makeText(context, "Password anda tidak sama!!", Toast.LENGTH_SHORT).show()
        }
    }
    fun regisHilang(){
        spr.edit().clear()
    }
}