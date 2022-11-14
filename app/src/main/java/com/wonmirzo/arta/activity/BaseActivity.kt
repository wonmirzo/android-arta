package com.wonmirzo.arta.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {
    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
    }

    fun callHistoryActivity(context: Context) {
        val intent = Intent(context, HistoryActivity::class.java)
        startActivity(intent)
    }
}