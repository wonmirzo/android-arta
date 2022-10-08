package com.wonmirzo.arta.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wonmirzo.arta.databinding.FragmentQoshimchaBinding

/** The name of the medication in the PageMedicineFragment and additional advice for the patient **/

class QoshimchaFragment : BaseFragment() {
    private var _binding: FragmentQoshimchaBinding? = null
    private val binding get() = _binding!!
    private var fragment: QoshimchaFragment? = null

    fun newInstance(): QoshimchaFragment? {
        if (fragment == null) {
            fragment = QoshimchaFragment()
        }
        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentQoshimchaBinding.inflate(inflater, container, false)
        val view = binding.root
        initViews()
        return view
    }

    private fun initViews() {

    }
}