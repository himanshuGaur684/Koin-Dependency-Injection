package com.example.koindi.ui

import androidx.lifecycle.ViewModel
import com.example.koindi.domain.use_cases.GetUserDataUseCase
import com.example.koindi.domain.use_cases.LoginUseCase

class AuthViewModel(
    private val loginUseCase: LoginUseCase,
    private val getUserDataUseCase: GetUserDataUseCase
) : ViewModel() {

    fun login() {
        loginUseCase()
    }

    fun getUser(){
        getUserDataUseCase()
    }


}