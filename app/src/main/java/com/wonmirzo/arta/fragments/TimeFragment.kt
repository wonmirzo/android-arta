package com.wonmirzo.arta.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wonmirzo.arta.databinding.FragmentTimeBinding

/**
 * TimeFragment to accurately store information and time
 * **/
class TimeFragment : BaseFragment() {
    private var _binding: FragmentTimeBinding? = null
    private val binding get() = _binding!!

    private var fragment: TimeFragment? = null

    fun newInstance(): TimeFragment? {
        if (fragment == null) {
            fragment = TimeFragment()
        }
        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentTimeBinding.inflate(inflater, container, false)
        val view = binding.root

        initViews()
        return view
    }

    private fun initViews() {

    }
}