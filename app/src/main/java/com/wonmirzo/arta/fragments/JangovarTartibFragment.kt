package com.wonmirzo.arta.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wonmirzo.arta.databinding.FragmentJangovarTartibBinding

/**
 * The first fragment to open is a google map and for short information about the patient
 * **/

class JangovarTartibFragment : BaseFragment() {

    private var fragment: JangovarTartibFragment? = null

    fun newInstance(): JangovarTartibFragment? {
        if (fragment == null) {
            fragment = JangovarTartibFragment()
        }
        return fragment
    }

    private var _binding: FragmentJangovarTartibBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentJangovarTartibBinding.inflate(inflater, container, false)
        val view = binding.root

        initViews()
        return view
    }


    private fun initViews() {

    }
}