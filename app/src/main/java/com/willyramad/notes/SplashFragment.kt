package com.willyramad.notes

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.willyramad.notes.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {
    lateinit var binding : FragmentSplashBinding
    lateinit var spS : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(layoutInflater)
        return binding.root
        val splashTime: Long = 3000

        Handler(Looper.myLooper()!!).postDelayed({
            spS = requireContext().getSharedPreferences("User", Context.MODE_PRIVATE)
            if (spS.getString("Username", "").equals("")){
                findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
            }else{
                if (spS.getString("Username","").equals(""))
                    findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
            }
        },splashTime)
        return view
    }
}