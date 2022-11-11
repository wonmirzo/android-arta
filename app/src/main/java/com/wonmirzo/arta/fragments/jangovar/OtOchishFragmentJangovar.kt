package com.wonmirzo.arta.fragments.jangovar

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.wonmirzo.arta.databinding.FragmentOtOchishJangovarBinding
import com.wonmirzo.arta.db.MainDatabase
import com.wonmirzo.arta.db.entity.OtOchish
import com.wonmirzo.arta.fragments.BaseFragment

class OtOchishFragmentJangovar : BaseFragment() {
    private val TAG = OtOchishFragmentJangovar::class.java.simpleName

    private var _binding: FragmentOtOchishJangovarBinding? = null
    private val binding get() = _binding!!

    private lateinit var mainDatabase: MainDatabase
    private var btnIsClicked = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOtOchishJangovarBinding.inflate(inflater, container, false)
        val view = binding.root
        initViews()
        return view
    }

    private fun initViews() {
        mainDatabase = MainDatabase.getInstance(requireContext())
        val allMalumot = mainDatabase.otOchishDao.getAllOtOchish()

        if (allMalumot.isNotEmpty()) {
            loadInfo()
        } else {
            loadDefaultInfo()
        }

        binding.apply {
            btnYangilash.setOnClickListener {
                showProgressBar(progressBar)
                refreshInfo()
            }
            llOtOchishJangovar.setOnClickListener {
                hideKeyboard(it)
            }

            btnBajarildi.setOnClickListener {
                btnIsClicked = true
                saveInfoToDatabase()
            }
        }
    }

    private fun loadDefaultInfo() {
        val defaultString = ""
        binding.apply {
            etNishonRaqami.setText(defaultString)
            etNishonXarak.setText(defaultString)
            etShkala.setText(defaultString)
            etZaryad.setText(defaultString)
            etSnaryadTuri.setText(defaultString)
            etPortlatgich.setText(defaultString)
            etPr.setText(defaultString)
            etUr.setText(defaultString)
            etUgr.setText(defaultString)
            etSnaryadSarfi.setText(defaultString)
            etKomanda.setText(defaultString)
        }
    }

    private fun loadInfo() {
        val allMalumot = mainDatabase.otOchishDao.getAllOtOchish()
        val malumot = allMalumot[0]

        binding.apply {
            etNishonRaqami.setText(malumot.nishonNumber)
            etNishonXarak.setText(malumot.nishonXarakteri)
            etShkala.setText(malumot.shkala)
            etZaryad.setText(malumot.zaryad)
            etSnaryadTuri.setText(malumot.snaryadTuri)
            etPortlatgich.setText(malumot.portlatgich)
            etPr.setText(malumot.pr)
            etUr.setText(malumot.ur)
            etUgr.setText(malumot.ugr)
            etSnaryadSarfi.setText(malumot.snaryadSarfi)
            etKomanda.setText(malumot.komanda)
        }
    }

    private fun saveInfoToDatabase() {
        clearDatabase()
        val otOchish = OtOchish(
            nishonNumber = binding.etNishonRaqami.text.toString(),
            nishonXarakteri = binding.etNishonXarak.text.toString(),
            shkala = binding.etShkala.text.toString(),
            zaryad = binding.etZaryad.text.toString(),
            snaryadTuri = binding.etSnaryadTuri.text.toString(),
            portlatgich = binding.etPortlatgich.text.toString(),
            pr = binding.etPr.text.toString(),
            ur = binding.etUr.text.toString(),
            ugr = binding.etUgr.text.toString(),
            snaryadSarfi = binding.etSnaryadSarfi.text.toString(),
            komanda = binding.etKomanda.text.toString()
        )

        mainDatabase.otOchishDao.insertOtOchish(otOchish)
        Toast.makeText(context, "Saqlandi", Toast.LENGTH_SHORT).show()
    }

    private fun clearDatabase() {
        mainDatabase.otOchishDao.deleteAllOtOchish()
    }

    private fun refreshInfo() {
        val handler = Handler()
        val runnable = Runnable() {
            binding.apply {
                etNishonRaqami.setText("2")
                hideProgressBar(progressBar)
            }
        }
        handler.postDelayed(runnable, 3000)
    }

    override fun onStop() {
        super.onStop()
        if (!btnIsClicked) {
            Toast.makeText(requireContext(), "Ma'lumotlar saqlanmadi", Toast.LENGTH_SHORT).show()
        } else {
            btnIsClicked = false
        }
    }
}