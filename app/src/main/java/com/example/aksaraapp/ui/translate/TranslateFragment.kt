package com.example.aksaraapp.ui.translate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aksaraapp.R
import com.example.aksaraapp.databinding.FragmentTranslateBinding

class TranslateFragment : Fragment() {

    private lateinit var binding : FragmentTranslateBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{

        binding = FragmentTranslateBinding.inflate(layoutInflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

}