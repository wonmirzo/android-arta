package com.wonmirzo.arta.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.wonmirzo.arta.R
import com.wonmirzo.arta.adapter.HistoryItemAdapter
import com.wonmirzo.arta.databinding.ActivityHistoryBinding
import com.wonmirzo.arta.db.PermanentDatabase

class HistoryActivity : BaseActivity() {
    private lateinit var binding: ActivityHistoryBinding

    private lateinit var permanentDatabase: PermanentDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        permanentDatabase = PermanentDatabase.getInstance(applicationContext)
        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(context)
        }
        refreshAdapter()
    }

    private fun refreshAdapter() {
        val adapter = HistoryItemAdapter(permanentDatabase.permanentDao.getAllInfo())
        binding.recyclerView.adapter = adapter
    }
}