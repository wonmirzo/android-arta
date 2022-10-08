package com.wonmirzo.arta.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wonmirzo.arta.databinding.FragmentStatementPageContinueBinding

/**
 * PageStatementFragmentContinue mainly to save data from checkboxes to the database
 * **/

class PageStatementFragmentContinue : BaseFragment() {
    private var _binding: FragmentStatementPageContinueBinding? = null
    private val binding get() = _binding!!

    private var fragment: PageStatementFragmentContinue? = null

    fun newInstance(): PageStatementFragmentContinue? {
        if (fragment == null) {
            fragment = PageStatementFragmentContinue()
        }
        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentStatementPageContinueBinding.inflate(inflater, container, false)
        val view = binding.root
        initViews()
        return view
    }

    private fun initViews() {
        binding.apply {

        }
    }
}