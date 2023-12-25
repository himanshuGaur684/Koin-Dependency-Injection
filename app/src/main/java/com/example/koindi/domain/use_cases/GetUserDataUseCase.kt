package com.example.koindi.domain.use_cases

import com.example.koindi.domain.AuthRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetUserDataUseCase : KoinComponent{


    private val authRepo : AuthRepository by inject()

    operator fun invoke() = authRepo.getUser()

}