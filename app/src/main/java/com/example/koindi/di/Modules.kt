package com.example.koindi.di

import com.example.koindi.data.ApiService
import com.example.koindi.data.ApiServiceImpl
import com.example.koindi.data.ApiServiceSecondServerImpl
import com.example.koindi.data.AuthRepoImpl
import com.example.koindi.domain.AuthRepository
import com.example.koindi.domain.use_cases.GetUserDataUseCase
import com.example.koindi.domain.use_cases.LoginUseCase
import com.example.koindi.servers.FirstServer
import com.example.koindi.servers.SecondServer
import com.example.koindi.ui.AuthViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module


const val LOGIN_SERVER = "login"
const val USER_SERVER = "user"

val authModule = module {

    factory { FirstServer() }
    factory { SecondServer() }


    factory<ApiService>(qualifier = named(LOGIN_SERVER)) { ApiServiceImpl(firstServer = get()) }
    factory<ApiService>(qualifier = named(USER_SERVER)) { ApiServiceSecondServerImpl(secondServer = get()) }

    factory<AuthRepository> {
        AuthRepoImpl(
            loginApiService = get(named(LOGIN_SERVER)), mainApiService = get(
                named(USER_SERVER)
            )
        )
    }

    factory { GetUserDataUseCase() }
    factory { LoginUseCase() }

    viewModel { AuthViewModel(loginUseCase = get(), getUserDataUseCase = get()) }

}

