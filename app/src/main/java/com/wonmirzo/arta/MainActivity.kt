package com.wonmirzo.arta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.wonmirzo.arta.adapter.ViewPagerAdapter
import com.wonmirzo.arta.databinding.ActivityMainBinding
import com.wonmirzo.arta.fragments.*

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName.toString()
    private lateinit var binding: ActivityMainBinding

    var index = 0

    // fragments
    private lateinit var jangovarTartibFragment: JangovarTartibFragment
    private lateinit var orudiyaHolatiFragment: OrudiyaHolatiFragment
    private lateinit var otOchishFragment: OtOchishFragment
    private lateinit var xabarlarFragment: XabarlarFragment
    private lateinit var qoshimchaFragment: QoshimchaFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initFragments()
        initViews()
    }

    private fun initViews() {
        manageFragments()
        binding.apply {
            setupViewPager(viewPager)
        }
    }

    private fun manageFragments() {
        binding.apply {
            lnHome?.setOnClickListener {
                index = 0
                viewPager?.currentItem = index
            }

            lyClock?.setOnClickListener {
                index = 1
                viewPager?.currentItem = index
            }

            llInspection?.setOnClickListener {
                index = 2
                viewPager?.currentItem = index
            }

            llDiagnosis?.setOnClickListener {
                index = 3
                viewPager?.currentItem = index
            }

            llDrugs?.setOnClickListener {
                index = 4
                viewPager?.currentItem = index
            }

            viewPager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {

                }

                override fun onPageSelected(position: Int) {
                    index = position
                    setFragment(index)
                }

                override fun onPageScrollStateChanged(state: Int) {}
            })
        }
    }

    private fun setFragment(index: Int) {
        when (index) {
            0 -> {
                binding.apply {

                }
            }
            1 -> {
                binding.apply {

                }
            }
            2 -> {
                binding.apply {

                }
            }
            3 -> {

            }
            else -> {
                binding.apply {

                }
            }
        }

    }

    private fun setupViewPager(viewPager: ViewPager?) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(JangovarTartibFragment())
        adapter.addFragment(OrudiyaHolatiFragment())
        adapter.addFragment(OtOchishFragment())
        adapter.addFragment(XabarlarFragment())
        adapter.addFragment(QoshimchaFragment())
        viewPager?.offscreenPageLimit = 3
        viewPager?.adapter = adapter
    }

    private fun initFragments() {
        jangovarTartibFragment = JangovarTartibFragment().newInstance()!!
        orudiyaHolatiFragment = OrudiyaHolatiFragment().newInstance()!!
        otOchishFragment = OtOchishFragment().newInstance()!!
        xabarlarFragment = XabarlarFragment().newInstance()!!
        qoshimchaFragment = QoshimchaFragment().newInstance()!!
    }
}