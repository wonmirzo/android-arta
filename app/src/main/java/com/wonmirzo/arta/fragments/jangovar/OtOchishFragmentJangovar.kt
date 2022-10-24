package com.wonmirzo.arta.fragments.jangovar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wonmirzo.arta.databinding.FragmentOtOchishJangovarBinding
import com.wonmirzo.arta.fragments.BaseFragment

class OtOchishFragmentJangovar : BaseFragment() {
    private var _binding: FragmentOtOchishJangovarBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOtOchishJangovarBinding.inflate(inflater, container, false)
        val view = binding.root
        initViews()
        return view
    }

    private fun initViews() {

    }

}