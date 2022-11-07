package com.wonmirzo.arta.fragments.jangovar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.wonmirzo.arta.databinding.FragmentMalumotBinding
import com.wonmirzo.arta.db.MainDatabase
import com.wonmirzo.arta.db.entity.Malumot
import com.wonmirzo.arta.fragments.BaseFragment

class MalumotFragment : BaseFragment() {
    private var _binding: FragmentMalumotBinding? = null
    private val binding get() = _binding!!

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
        binding.apply {
            llMalumot.setOnClickListener {
                hideKeyboard(it)
            }

            btnKiritish.setOnClickListener {
                saveInfoToDatabase()
            }
        }
    }

    private fun saveInfoToDatabase() {
        val database = MainDatabase.getInstance(requireContext())

        val malumot = Malumot(
            asosiyYn1 = binding.etMalumotAsosiyYn.text.toString(),
            asosiyYn2 = binding.etMalumotAsosiyYn2.text.toString(),
            zaxiraYn1 = binding.etMalumotZaxiraYn.text.toString(),
            zaxiraYn2 = binding.etMalumotZaxiraYn2.text.toString(),
            snaryadSoni = binding.etMalumotSnaryadSoni.text.toString(),
            qoldiq = binding.etMalumotQoldiq.text.toString()
        )
        database.malumotDao.insertMalumot(malumot)

        Toast.makeText(context, "Saqlandi!", Toast.LENGTH_SHORT).show()
    }
}