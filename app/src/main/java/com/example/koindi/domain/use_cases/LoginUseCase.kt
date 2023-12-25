package com.example.koindi.domain.use_cases

import com.example.koindi.domain.AuthRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LoginUseCase : KoinComponent{

    private val authRepository:AuthRepository by inject()


    operator fun invoke(): Boolean {
        return authRepository.login("himanshu","password")
    }

}