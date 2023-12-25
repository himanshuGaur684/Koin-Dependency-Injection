package com.example.koindi.data

import com.example.koindi.servers.FirstServer
import com.example.koindi.servers.SecondServer

interface ApiService {

    fun login(name: String, password: String): Boolean

    fun getUser(): String

}

class ApiServiceImpl(private val firstServer: FirstServer) : ApiService {
    override fun login(name: String, password: String): Boolean {
        return firstServer.performLogin()
    }

    override fun getUser(): String {
        return "wrong server for user data"
    }
}

class ApiServiceSecondServerImpl(private val secondServer: SecondServer) : ApiService {
    override fun login(name: String, password: String): Boolean {
        return false
    }

    override fun getUser(): String {
        return secondServer.getUser()
    }
}

