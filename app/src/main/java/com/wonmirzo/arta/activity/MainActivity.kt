package com.wonmirzo.arta.activity

import android.os.Bundle
import android.widget.Toast
import com.wonmirzo.arta.R
import com.wonmirzo.arta.databinding.ActivityMainBinding
import com.wonmirzo.arta.db.MainDatabase
import com.wonmirzo.arta.db.entity.MainInfo
import com.wonmirzo.arta.fragments.jangovar.JangovarTartibFragment
import com.wonmirzo.arta.utils.HistoryButtonClickedListener

class MainActivity : BaseActivity(), HistoryButtonClickedListener {
    private val TAG = MainActivity::class.java.simpleName.toString()
    private lateinit var binding: ActivityMainBinding

    private lateinit var mainDatabase: MainDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    override fun onDestroy() {
        super.onDestroy()
        clearAllInfoFromDatabase()
    }

    override fun buttonClicked() {
        callHistoryActivity(this@MainActivity)
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
                saveInfoToPermanentDatabase()
            }
        }
    }

    private fun saveInfoToPermanentDatabase() {

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


    private fun clearAllInfoFromDatabase() {
        mainDatabase.mainDao.deleteAllMainInfo()
        mainDatabase.malumotDao.deleteAllMalumot()
        mainDatabase.otOchishDao.deleteAllOtOchish()
    }
}