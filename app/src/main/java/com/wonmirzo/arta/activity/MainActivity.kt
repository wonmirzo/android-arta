package com.wonmirzo.arta.activity

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.wonmirzo.arta.R
import com.wonmirzo.arta.databinding.ActivityMainBinding
import com.wonmirzo.arta.db.MainDatabase
import com.wonmirzo.arta.db.PermanentDatabase
import com.wonmirzo.arta.db.entity.MainInfo
import com.wonmirzo.arta.db.entity.PermanentInfo
import com.wonmirzo.arta.fragments.jangovar.JangovarTartibFragment
import com.wonmirzo.arta.utils.HistoryButtonClickedListener
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class MainActivity : BaseActivity(), HistoryButtonClickedListener {
    private val TAG = MainActivity::class.java.simpleName.toString()
    private lateinit var binding: ActivityMainBinding

    private lateinit var mainDatabase: MainDatabase
    private lateinit var permanentDatabase: PermanentDatabase

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

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initViews() {
        mainDatabase = MainDatabase.getInstance(applicationContext)
        permanentDatabase = PermanentDatabase.getInstance(applicationContext)

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

    @RequiresApi(Build.VERSION_CODES.O)
    private fun saveInfoToPermanentDatabase() {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
        val formatted = current.format(formatter)

        val mainInfo = mainDatabase.mainDao.getAllMainInfo()[0]
        val malumot = mainDatabase.malumotDao.getAllMalumot()[0]
        val otOchish = mainDatabase.otOchishDao.getAllOtOchish()[0]
        val permanentInfo =
            PermanentInfo(
                mainInfo = mainInfo,
                malumot = malumot,
                otOchish = otOchish,
                date = formatted
            )
        permanentDatabase.permanentDao.insertInfo(permanentInfo)
        Toast.makeText(context, "Saqlandi!!", Toast.LENGTH_SHORT).show()
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
            raschyot = binding.etJangovarRaschyot?.text.toString(),
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