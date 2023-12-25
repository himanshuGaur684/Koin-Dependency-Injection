package com.example.koindi.servers

import android.util.Log

class FirstServer() {
    fun performLogin(): Boolean {
        Log.d("koin-DI", "performLogin: first server")
        return true
    }
}


class SecondServer() {
    fun getUser(): String {
        Log.d("koin-DI", "getUser: second server")
        return "Himanshu Gaur"
    }
}