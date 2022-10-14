package com.wonmirzo.arta.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.wonmirzo.arta.R
import com.wonmirzo.arta.databinding.FragmentOrudiyaHolatiBinding

/**
 * TimeFragment to accurately store information and time
 * **/
class OrudiyaHolatiFragment : BaseFragment() {
    private var _binding: FragmentOrudiyaHolatiBinding? = null
    private val binding get() = _binding!!

    private var fragment: OrudiyaHolatiFragment? = null

    fun newInstance(): OrudiyaHolatiFragment? {
        if (fragment == null) {
            fragment = OrudiyaHolatiFragment()
        }
        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentOrudiyaHolatiBinding.inflate(inflater, container, false)
        val view = binding.root

        initViews()
        return view
    }

    private fun initViews() {
        setSpinnerOrudiyaTuri()
    }

    private fun setSpinnerOrudiyaTuri() {
        val orudiyaTurlari = resources.getStringArray(R.array.spinner_orudiya_turi)
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.spinner_orudiya_turi,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerOrudiyaTuri.adapter = adapter
        }

        binding.spinnerOrudiyaTuri.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(
                        requireContext(),
                        orudiyaTurlari[position],
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }
    }
}