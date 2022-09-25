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
import com.willyramad.notes.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    lateinit var binding : FragmentLoginBinding
    lateinit var spl : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        spl = requireContext().getSharedPreferences("User",  Context.MODE_PRIVATE)

        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            Login()
        }
        binding.btnRegis.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

    }
    fun Login(){
        var ambilDataUser = spl.getString("Username", "")
        var ambilDataPass = spl.getString("Password","")
        var user = binding.edUsername.text.toString()
        var pass = binding.edPassword.text.toString()
        if (user.isEmpty()&& pass.isEmpty()){
            Toast.makeText(context, "isi Username dan Password tidak boleh kosong", Toast.LENGTH_SHORT).show()
        }else{
            if (user ==  ambilDataUser.toString() &&  pass == ambilDataPass.toString()){
                Toast.makeText(context, "Anda telah berhasil Login", Toast.LENGTH_SHORT).show()
            }else{
                if (user != ambilDataUser.toString() || pass != ambilDataPass.toString()){
                    Toast.makeText(context, "Username dan Password salah", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.loginFragment)
                }
            }
        }
    }
}