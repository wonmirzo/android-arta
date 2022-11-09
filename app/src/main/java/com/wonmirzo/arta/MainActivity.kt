package com.wonmirzo.arta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.wonmirzo.arta.databinding.ActivityMainBinding
import com.wonmirzo.arta.db.MainDatabase
import com.wonmirzo.arta.db.entity.MainInfo
import com.wonmirzo.arta.fragments.jangovar.JangovarTartibFragment

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName.toString()
    private lateinit var binding: ActivityMainBinding

    private lateinit var mainDatabase: MainDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        mainDatabase = MainDatabase.getInstance(applicationContext)

        val allMainInfo = mainDatabase.mainDao.getAllMainInfo()

        if (allMainInfo.isNotEmpty()) {
            loadInfo()
        }

        binding.apply {
            supportFragmentManager.beginTransaction().replace(R.id.flMain, JangovarTartibFragment())
                .commit()

            btnYakunlash?.setOnClickListener {
                saveInfoToDatabase()
            }
        }
    }

    private fun loadInfo() {
        val mainInfo = mainDatabase.mainDao.getAllMainInfo()[0]

        binding.apply {
            etJangovarAdn?.setText(mainInfo.adnNumber)
            etJangovarArtileriyaBatareyasi?.setText(mainInfo.artileriyaBatareyasi)
            etJangovarRaschyot?.setText(mainInfo.raschyot)
        }
    }

    private fun saveInfoToDatabase() {
        clearDatabase()
        val info = MainInfo(
            adnNumber = binding.etJangovarAdn?.text.toString(),
            artileriyaBatareyasi = binding.etJangovarArtileriyaBatareyasi?.text.toString(),
            raschyot = binding.etJangovarRaschyot?.text.toString()
        )

        mainDatabase.mainDao.insertMain(info)
        Toast.makeText(this@MainActivity, "Saqlandi", Toast.LENGTH_SHORT).show()
    }

    private fun clearDatabase() {
        mainDatabase.mainDao.deleteAllMainInfo()
    }

}