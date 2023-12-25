package com.example.koindi.domain

interface AuthRepository {

    fun login(name: String, password: String): Boolean

    fun getUser():String

}