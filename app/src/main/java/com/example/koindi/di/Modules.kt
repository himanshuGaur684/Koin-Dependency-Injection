package com.example.koindi.di

import com.example.koindi.data.ApiService
import com.example.koindi.data.ApiServiceImpl
import com.example.koindi.data.ApiServiceSecondServerImpl
import com.example.koindi.data.AuthRepoImpl
import com.example.koindi.domain.AuthRepository
import com.example.koindi.domain.use_cases.GetUserDataUseCase
import com.example.koindi.domain.use_cases.LoginUseCase
import com.example.koindi.room.AppDao
import com.example.koindi.room.AppDatabase
import com.example.koindi.servers.FirstServer
import com.example.koindi.servers.SecondServer
import com.example.koindi.ui.AuthViewModel
import com.example.koindi.ui.MainActivity
import com.example.koindi.ui.ScopeTestingClass
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


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

    single {
        Retrofit.Builder().baseUrl("").addConverterFactory(GsonConverterFactory.create()).build()
    }

    single { AppDatabase.getDataBase(context = androidContext()) }
    factory { get<AppDatabase>().appDao() }

    scope<MainActivity> {
        scoped {
            ScopeTestingClass()
        }
    }

}

