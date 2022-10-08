package com.wonmirzo.arta

import android.graphics.Color
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
    private lateinit var mapsInfoFragment: MapsInfoFragment
    private lateinit var timeFragment: TimeFragment
    private lateinit var pageStatementFragment: PageStatementFragment
    private lateinit var pageStatementFragmentContinue: PageStatementFragmentContinue
    private lateinit var pageMedicineFragment: PageMedicineFragment

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
        if (index == 0) {
            binding.apply {
                lnHome!!.setBackgroundColor(Color.WHITE)
                lnHome.setBackgroundResource(R.drawable.background_rounded_corners_left)
                tvHome!!.setTextColor(Color.BLACK)

                llInspection!!.setBackgroundColor(Color.TRANSPARENT)
                tvInspection!!.setTextColor(Color.RED)

                llDiagnosis!!.setBackgroundColor(Color.TRANSPARENT)
                tvDiagnosis!!.setTextColor(Color.RED)

                llDrugs!!.setBackgroundColor(Color.TRANSPARENT)
                tvDrugs!!.setTextColor(Color.RED)

                lyClock!!.setBackgroundColor(Color.TRANSPARENT)
                tvClock!!.setTextColor(Color.RED)
            }
        } else if (index == 1) {
            binding.apply {
                lnHome!!.setBackgroundColor(Color.TRANSPARENT)
                tvHome!!.setTextColor(Color.RED)

                llInspection!!.setBackgroundColor(Color.TRANSPARENT)
                tvInspection!!.setTextColor(Color.RED)

                llDiagnosis!!.setBackgroundColor(Color.TRANSPARENT)
                tvDiagnosis!!.setTextColor(Color.RED)

                llDrugs!!.setBackgroundColor(Color.TRANSPARENT)
                tvDrugs!!.setTextColor(Color.RED)

                lyClock!!.setBackgroundColor(Color.WHITE)
                tvClock!!.setTextColor(Color.BLACK)
            }
        } else if (index == 2) {
            binding.apply {
                llInspection!!.setBackgroundColor(Color.WHITE)
                tvInspection!!.setTextColor(Color.BLACK)

                lnHome!!.setBackgroundColor(Color.TRANSPARENT)
                tvHome!!.setTextColor(Color.RED)

                llDiagnosis!!.setBackgroundColor(Color.TRANSPARENT)
                tvDiagnosis!!.setTextColor(Color.RED)

                llDrugs!!.setBackgroundColor(Color.TRANSPARENT)
                tvDrugs!!.setTextColor(Color.RED)

                lyClock!!.setBackgroundColor(Color.TRANSPARENT)
                tvClock!!.setTextColor(Color.RED)
            }
        } else if (index == 3) {
            binding.apply {
                llDiagnosis!!.setBackgroundColor(Color.WHITE)
                tvDiagnosis!!.setTextColor(Color.BLACK)

                lnHome!!.setBackgroundColor(Color.TRANSPARENT)
                tvHome!!.setTextColor(Color.RED)

                llInspection!!.setBackgroundColor(Color.TRANSPARENT)
                tvInspection!!.setTextColor(Color.RED)

                llDrugs!!.setBackgroundColor(Color.TRANSPARENT)
                tvDrugs!!.setTextColor(Color.RED)

                lyClock!!.setBackgroundColor(Color.TRANSPARENT)
                tvClock!!.setTextColor(Color.RED)
            }
        } else {
            binding.apply {
                llDrugs!!.setBackgroundColor(Color.WHITE)
                tvDrugs!!.setTextColor(Color.BLACK)

                lnHome!!.setBackgroundColor(Color.TRANSPARENT)
                tvHome!!.setTextColor(Color.RED)

                llInspection!!.setBackgroundColor(Color.TRANSPARENT)
                tvInspection!!.setTextColor(Color.RED)

                llDiagnosis!!.setBackgroundColor(Color.TRANSPARENT)
                tvDiagnosis!!.setTextColor(Color.RED)

                lyClock!!.setBackgroundColor(Color.TRANSPARENT)
                tvClock!!.setTextColor(Color.RED)
            }
        }

    }

    private fun setupViewPager(viewPager: ViewPager?) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(MapsInfoFragment())
        adapter.addFragment(TimeFragment())
        adapter.addFragment(PageStatementFragment())
        adapter.addFragment(PageStatementFragmentContinue())
        adapter.addFragment(PageMedicineFragment())
        viewPager?.offscreenPageLimit = 3
        viewPager?.adapter = adapter
    }

    private fun initFragments() {
        mapsInfoFragment = MapsInfoFragment().newInstance()!!
        timeFragment = TimeFragment().newInstance()!!
        pageStatementFragment = PageStatementFragment().newInstance()!!
        pageStatementFragmentContinue = PageStatementFragmentContinue().newInstance()!!
        pageMedicineFragment = PageMedicineFragment().newInstance()!!
    }
}