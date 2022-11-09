package com.wonmirzo.arta.fragments.jangovar

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.wonmirzo.arta.databinding.FragmentMalumotBinding
import com.wonmirzo.arta.db.MainDatabase
import com.wonmirzo.arta.db.entity.Malumot
import com.wonmirzo.arta.fragments.BaseFragment

class MalumotFragment : BaseFragment() {
    private val TAG = MalumotFragment::class.java.simpleName

    private var _binding: FragmentMalumotBinding? = null
    private val binding get() = _binding!!

    private lateinit var mainDatabase: MainDatabase
    private var btnIsClicked = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMalumotBinding.inflate(inflater, container, false)
        val view = binding.root
        initViews()
        return view
    }

    private fun initViews() {
        mainDatabase = MainDatabase.getInstance(requireContext())

        val allMalumot = mainDatabase.malumotDao.getAllMalumot()

        if (allMalumot.isNotEmpty()) {
            loadInfo()
        }

        binding.apply {
            llMalumot.setOnClickListener {
                hideKeyboard(it)
            }

            btnKiritish.setOnClickListener {
                btnIsClicked = true
                saveInfoToDatabase()
            }
        }
    }

    private fun loadInfo() {
        val allMalumot = mainDatabase.malumotDao.getAllMalumot()

        binding.apply {
            etMalumotAsosiyYn.setText(allMalumot[0].asosiyYn1)
            etMalumotAsosiyYn2.setText(allMalumot[0].asosiyYn2)
            etMalumotZaxiraYn.setText(allMalumot[0].zaxiraYn1)
            etMalumotZaxiraYn2.setText(allMalumot[0].zaxiraYn2)
            etMalumotSnaryadSoni.setText(allMalumot[0].snaryadSoni)
        }
    }

    private fun saveInfoToDatabase() {
        clearDatabase()
        val malumot = Malumot(
            asosiyYn1 = binding.etMalumotAsosiyYn.text.toString(),
            asosiyYn2 = binding.etMalumotAsosiyYn2.text.toString(),
            zaxiraYn1 = binding.etMalumotZaxiraYn.text.toString(),
            zaxiraYn2 = binding.etMalumotZaxiraYn2.text.toString(),
            snaryadSoni = binding.etMalumotSnaryadSoni.text.toString(),
            qoldiq = binding.etMalumotQoldiq.text.toString()
        )
        mainDatabase.malumotDao.insertMalumot(malumot)

        Toast.makeText(context, "Saqlandi!", Toast.LENGTH_SHORT).show()
    }

    private fun clearDatabase() {
        mainDatabase.malumotDao.deleteAllMalumot()
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

