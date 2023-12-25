package com.example.koindi.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.koindi.databinding.ActivityMainBinding
import com.example.koindi.di.authModule
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val authViewmodel:AuthViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            authViewmodel.login()
        }

        binding.btnGetUser.setOnClickListener {
            authViewmodel.getUser()
        }

        loadKoinModules(authModule)


    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(authModule)
    }
}