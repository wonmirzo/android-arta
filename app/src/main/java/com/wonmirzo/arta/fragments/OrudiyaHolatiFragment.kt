package com.wonmirzo.arta.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    }
}