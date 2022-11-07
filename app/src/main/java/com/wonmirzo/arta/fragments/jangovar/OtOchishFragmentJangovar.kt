package com.wonmirzo.arta.fragments.jangovar

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wonmirzo.arta.databinding.FragmentOtOchishJangovarBinding
import com.wonmirzo.arta.db.MainDatabase
import com.wonmirzo.arta.db.entity.OtOchish
import com.wonmirzo.arta.fragments.BaseFragment

class OtOchishFragmentJangovar : BaseFragment() {
    private var _binding: FragmentOtOchishJangovarBinding? = null
    private val binding get() = _binding!!

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
        binding.apply {
            btnYangilash.setOnClickListener {
                showProgressBar(progressBar)
                refreshInfo()
            }
            llOtOchishJangovar.setOnClickListener {
                hideKeyboard(it)
            }

            btnBajarildi.setOnClickListener {
                saveInfoToDatabase()
            }
        }
    }

    private fun saveInfoToDatabase() {
        val database = MainDatabase.getInstance(requireContext())
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

        database.otOchishDao.insertOtOchish(otOchish)
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

}