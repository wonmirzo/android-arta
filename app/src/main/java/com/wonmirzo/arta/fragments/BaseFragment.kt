package com.wonmirzo.arta.fragments

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ProgressBar
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {

    fun hideKeyboard(view: View) {
        val hide =
            requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        hide.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun showProgressBar(pb: ProgressBar) {
        pb.visibility = View.VISIBLE
    }

    fun hideProgressBar(pb: ProgressBar) {
        pb.visibility = View.GONE
    }
}