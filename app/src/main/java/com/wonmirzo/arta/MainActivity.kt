package com.wonmirzo.arta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.wonmirzo.arta.adapter.ViewPagerAdapter
import com.wonmirzo.arta.databinding.ActivityMainBinding
import com.wonmirzo.arta.db.MainDatabase
import com.wonmirzo.arta.db.entity.MainInfo
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

            btnYakunlash?.setOnClickListener {
                saveInfo()
            }
        }
    }

    private fun saveInfo() {
        val database = MainDatabase.getInstance(applicationContext)
        val info = MainInfo(
            adnNumber = binding.etJangovarAdn?.text.toString(),
            artileriyaBatareyasi = binding.etJangovarArtileriyaBatareyasi?.text.toString(),
            raschyot = binding.etJangovarRaschyot?.text.toString()
        )

        database.mainDao.insertMain(info)
        Toast.makeText(this@MainActivity, "Saqlandi", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "${database.mainDao.getAllMainInfo()[0]}")
    }

}