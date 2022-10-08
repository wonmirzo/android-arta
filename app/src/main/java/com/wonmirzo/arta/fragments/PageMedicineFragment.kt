package com.wonmirzo.arta.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wonmirzo.arta.databinding.FragmentMedicinePageBinding

/** The name of the medication in the PageMedicineFragment and additional advice for the patient **/

class PageMedicineFragment : BaseFragment() {
    private var _binding: FragmentMedicinePageBinding? = null
    private val binding get() = _binding!!
    private var fragment: PageMedicineFragment? = null

    fun newInstance(): PageMedicineFragment? {
        if (fragment == null) {
            fragment = PageMedicineFragment()
        }
        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentMedicinePageBinding.inflate(inflater, container, false)
        val view = binding.root
        initViews()
        return view
    }

    private fun initViews() {

    }
}