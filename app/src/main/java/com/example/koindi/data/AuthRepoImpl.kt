package com.example.koindi.data

import com.example.koindi.domain.AuthRepository


class AuthRepoImpl(
    private val loginApiService: ApiService,
    private val mainApiService: ApiService
) : AuthRepository {
    override fun login(name: String, password: String): Boolean {
        return loginApiService.login(name, password)
    }

    override fun getUser(): String {
        return mainApiService.getUser()
    }
}