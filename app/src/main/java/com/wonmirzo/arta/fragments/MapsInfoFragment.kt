package com.wonmirzo.arta.fragments

import android.os.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wonmirzo.arta.databinding.FragmentInfoMapsBinding

/**
 * The first fragment to open is a google map and for short information about the patient
 * **/

class MapsInfoFragment : BaseFragment() {

    private var fragment: MapsInfoFragment? = null

    fun newInstance(): MapsInfoFragment? {
        if (fragment == null) {
            fragment = MapsInfoFragment()
        }
        return fragment
    }

    private var _binding: FragmentInfoMapsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentInfoMapsBinding.inflate(inflater, container, false)
        val view = binding.root

        initViews()
        return view
    }


    private fun initViews() {

    }
}