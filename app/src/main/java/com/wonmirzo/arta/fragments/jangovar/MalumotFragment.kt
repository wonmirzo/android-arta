package com.wonmirzo.arta.fragments.jangovar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wonmirzo.arta.databinding.FragmentMalumotBinding
import com.wonmirzo.arta.fragments.BaseFragment

class MalumotFragment : BaseFragment() {
    private var _binding: FragmentMalumotBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMalumotBinding.inflate(inflater, container, false)
        val view = binding.root
        initViews()
        return view
    }

    private fun initViews() {

    }
}