package com.wonmirzo.arta.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wonmirzo.arta.R
import com.wonmirzo.arta.databinding.ActivityHistoryBinding

class HistoryActivity : BaseActivity() {
    private lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {

    }
}