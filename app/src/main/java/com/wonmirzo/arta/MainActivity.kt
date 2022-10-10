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
            llJangovar?.setOnClickListener {
                index = 0
                viewPager?.currentItem = index
            }

            llOrudiya?.setOnClickListener {
                index = 1
                viewPager?.currentItem = index
            }

            llOtOchish?.setOnClickListener {
                index = 2
                viewPager?.currentItem = index
            }

            llXabarlar?.setOnClickListener {
                index = 3
                viewPager?.currentItem = index
            }

            llQoshimcha?.setOnClickListener {
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
                    llJangovar.setBackgroundResource(R.drawable.background_rounded_corners_left_selected)
                    llOrudiya?.setBackgroundResource(R.drawable.background_rounded_corners_left)
                    llOtOchish?.setBackgroundResource(R.drawable.background_rounded_corners_left)
                    llQoshimcha?.setBackgroundResource(R.drawable.background_rounded_corners_left)
                    llXabarlar?.setBackgroundResource(R.drawable.background_rounded_corners_left)
                }
            }
            1 -> {
                binding.apply {
                    llJangovar.setBackgroundResource(R.drawable.background_rounded_corners_left)
                    llOrudiya?.setBackgroundResource(R.drawable.background_rounded_corners_left_selected)
                    llOtOchish?.setBackgroundResource(R.drawable.background_rounded_corners_left)
                    llQoshimcha?.setBackgroundResource(R.drawable.background_rounded_corners_left)
                    llXabarlar?.setBackgroundResource(R.drawable.background_rounded_corners_left)
                }
            }
            2 -> {
                binding.apply {
                    llJangovar.setBackgroundResource(R.drawable.background_rounded_corners_left)
                    llOrudiya?.setBackgroundResource(R.drawable.background_rounded_corners_left)
                    llOtOchish?.setBackgroundResource(R.drawable.background_rounded_corners_left_selected)
                    llQoshimcha?.setBackgroundResource(R.drawable.background_rounded_corners_left)
                    llXabarlar?.setBackgroundResource(R.drawable.background_rounded_corners_left)
                }
            }
            3 -> {
                binding.apply {
                    llJangovar.setBackgroundResource(R.drawable.background_rounded_corners_left)
                    llOrudiya?.setBackgroundResource(R.drawable.background_rounded_corners_left)
                    llOtOchish?.setBackgroundResource(R.drawable.background_rounded_corners_left)
                    llXabarlar?.setBackgroundResource(R.drawable.background_rounded_corners_left_selected)
                    llQoshimcha?.setBackgroundResource(R.drawable.background_rounded_corners_left)
                }
            }
            4 -> {
                binding.apply {
                    llJangovar.setBackgroundResource(R.drawable.background_rounded_corners_left)
                    llOrudiya?.setBackgroundResource(R.drawable.background_rounded_corners_left)
                    llOtOchish?.setBackgroundResource(R.drawable.background_rounded_corners_left)
                    llXabarlar?.setBackgroundResource(R.drawable.background_rounded_corners_left)
                    llQoshimcha?.setBackgroundResource(R.drawable.background_rounded_corners_left_selected)
                }
            }
            else -> {

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