package com.wonmirzo.arta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.wonmirzo.arta.adapter.ViewPagerAdapter
import com.wonmirzo.arta.databinding.ActivityMainBinding
import com.wonmirzo.arta.fragments.*
import com.wonmirzo.arta.fragments.jangovar.JangovarTartibFragment

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName.toString()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        binding.apply {
            supportFragmentManager.beginTransaction().replace(R.id.flMain, JangovarTartibFragment())
                .commit()
        }
    }

}