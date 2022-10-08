package com.wonmirzo.arta.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wonmirzo.arta.databinding.FragmentStatementPageBinding

/**
 * PageStatementFragment mainly to save data from checkboxes to the database
 * **/
class PageStatementFragment : BaseFragment() {
    private var _binding: FragmentStatementPageBinding? = null
    private val binding get() = _binding!!
    private var fragment: PageStatementFragment? = null

    fun newInstance(): PageStatementFragment? {
        return PageStatementFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentStatementPageBinding.inflate(inflater, container, false)
        val view = binding.root
        initViews()
        return view
    }

    private fun initViews() {

    }
}