package com.example.koindi.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.koindi.databinding.ActivityMainBinding
import org.koin.androidx.scope.activityScope
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinScopeComponent
import org.koin.core.scope.Scope

class MainActivity : AppCompatActivity(), KoinScopeComponent {

    override val scope: Scope by activityScope()

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val authViewmodel: AuthViewModel by viewModel()

    private val scopeTestingClass: ScopeTestingClass by scope.inject()

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

        binding.btnGoToSecondActivity.setOnClickListener {
//            scopeTestingClass.injectedProperly()
            startActivity(Intent(this@MainActivity, SecondActivity::class.java))
        }


    }

}