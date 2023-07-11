package com.example.aksaraapp.ui.auth.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aksaraapp.R
import com.example.aksaraapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}