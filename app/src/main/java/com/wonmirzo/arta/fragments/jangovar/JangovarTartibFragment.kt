package com.wonmirzo.arta.fragments.jangovar

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wonmirzo.arta.R
import com.wonmirzo.arta.databinding.FragmentJangovarTartibBinding
import com.wonmirzo.arta.fragments.BaseFragment
import com.wonmirzo.arta.utils.HistoryButtonClickedListener

class JangovarTartibFragment : BaseFragment() {
    private var _binding: FragmentJangovarTartibBinding? = null
    private val binding get() = _binding!!

    private var listener: HistoryButtonClickedListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentJangovarTartibBinding.inflate(inflater, container, false)
        val view = binding.root

        initViews()
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is HistoryButtonClickedListener) {
            context
        } else {
            throw RuntimeException("$context must implement HistoryButtonClicked")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    private fun initViews() {
        buttonBg()
        childFragmentManager.beginTransaction().replace(R.id.flJangovar, MalumotFragment()).commit()

        binding.btnHistory.setOnClickListener {
            listener!!.buttonClicked()
        }
    }

    private fun buttonBg() {
        binding.apply {
            llOtOchishJangovar.setOnClickListener {
                llMalumot.setBackgroundResource(R.drawable.bg_jangovar_button_unselected)
                llOtOchishJangovar.setBackgroundResource(R.drawable.bg_jangovar_button)
                childFragmentManager.beginTransaction()
                    .replace(R.id.flJangovar, OtOchishFragmentJangovar()).commit()
            }
            llMalumot.setOnClickListener {
                llMalumot.setBackgroundResource(R.drawable.bg_jangovar_button)
                llOtOchishJangovar.setBackgroundResource(R.drawable.bg_jangovar_button_unselected)
                childFragmentManager.beginTransaction().replace(R.id.flJangovar, MalumotFragment())
                    .commit()
            }
        }
    }
}