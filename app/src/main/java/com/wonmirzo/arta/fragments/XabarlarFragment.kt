package com.wonmirzo.arta.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wonmirzo.arta.databinding.FragmentXabarlarBinding

/**
 * PageStatementFragmentContinue mainly to save data from checkboxes to the database
 * **/

class XabarlarFragment : BaseFragment() {
    private var _binding: FragmentXabarlarBinding? = null
    private val binding get() = _binding!!

    private var fragment: XabarlarFragment? = null

    fun newInstance(): XabarlarFragment? {
        if (fragment == null) {
            fragment = XabarlarFragment()
        }
        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentXabarlarBinding.inflate(inflater, container, false)
        val view = binding.root
        initViews()
        return view
    }

    private fun initViews() {
        binding.apply {

        }
    }
}