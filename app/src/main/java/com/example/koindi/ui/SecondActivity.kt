package com.example.koindi.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.koindi.R
import org.koin.androidx.scope.activityScope
import org.koin.core.component.KoinScopeComponent
import org.koin.core.component.inject
import org.koin.core.scope.Scope

class SecondActivity : AppCompatActivity(),KoinScopeComponent {

    override val scope: Scope by activityScope()

    private val scopeTestingClass:ScopeTestingClass by scope.inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        scopeTestingClass.injectedProperly()

    }
}


class ScopeTestingClass() {
    fun injectedProperly() {
        Log.d("Koin-di", "injectedProperly: done")
    }
}
