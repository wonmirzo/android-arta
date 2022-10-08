package com.wonmirzo.arta.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wonmirzo.arta.databinding.FragmentOtOchishBinding

/**
 * PageStatementFragment mainly to save data from checkboxes to the database
 * **/
class OtOchishFragment : BaseFragment() {
    private var _binding: FragmentOtOchishBinding? = null
    private val binding get() = _binding!!
    private var fragment: OtOchishFragment? = null

    fun newInstance(): OtOchishFragment? {
        return OtOchishFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentOtOchishBinding.inflate(inflater, container, false)
        val view = binding.root
        initViews()
        return view
    }

    private fun initViews() {

    }
}