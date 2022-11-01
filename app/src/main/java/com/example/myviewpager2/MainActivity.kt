package com.example.myviewpager2

import android.app.Activity
import android.content.res.Resources
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.size
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.google.android.material.tabs.TabLayout
import kotlin.math.roundToInt


class MainActivity : AppCompatActivity() {
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2
    private val TAG = "MainActivity"
    private lateinit var layout: LinearLayout

    var shouldShowIndicator = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)
        layout = findViewById(R.id.linearLayout)
        val adapter = MyAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter


        addCardIndicators(this@MainActivity,layout,adapter.items.size,0)

        viewPager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                addCardIndicators(this@MainActivity,layout,adapter.items.size,position)
                layout.removeAllViews()

//                if (!shouldShowIndicator) {
//                    populateCardIndicators(this@MainActivity, layout, adapter.items.size, position)
//                    shouldShowIndicator = true
//                } else {
//                    addCardIndicators2(this@MainActivity, layout, adapter.items.size, position)
//                }
            }
        })

//        addCardIndicators(this@MainActivity,layout,adapter.items.size,0)

    }

//    override fun onResume() {
//        super.onResume()
//        populateCardIndicators(this@MainActivity, layout, 4, 0)
//    }


    fun addCardIndicators(
        activity: Activity,
        linearLayout: LinearLayout,
        size: Int,
        currentPosition: Int
    ) {
//        if (currentPosition != 0) {
//            linearLayout.removeAllViews()
//            Log.d(TAG, "addCardIndicators: $currentPosition")
//            Log.d(TAG, "addCardIndicators: ")
//        }

        val dots = ArrayList<ImageView>()

        for (i in 0 until size) {
            val v = ImageView(this)
            val widthHeight: Int = convertDpToPx(8)
            v.apply {
                layoutParams = getParams(widthHeight, widthHeight)
                setImageResource(R.drawable.shape_circle_white)
                setColorFilter(
                    ContextCompat.getColor(activity, R.color.teal_700),
                    PorterDuff.Mode.SRC_ATOP
                )
            }
            dots.add(v)

            if (i == currentPosition) {
                val height: Int = convertDpToPx(8)
                val width: Int = convertDpToPx(15)
                dots[currentPosition].apply {
                    setImageResource(R.drawable.shape_selected)
                    layoutParams = getParams(width, height)
                    setColorFilter(
                        ContextCompat.getColor(activity, R.color.teal_700),
                        PorterDuff.Mode.SRC_ATOP
                    )
                }
            }
            linearLayout.addView(dots[i])
        }
    }


    private fun convertDpToPx(dp: Int): Int {
        return (dp * (Resources.getSystem()
            .displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)).roundToInt()
    }

    private fun getParams(width: Int, height: Int): ViewGroup.LayoutParams {
        val params = LinearLayout.LayoutParams(ViewGroup.LayoutParams(width, height))
        params.setMargins(10, 10, 10, 10)
        return params
    }


    fun addCardIndicators2(
        activity: Activity,
        linearLayout: LinearLayout,
        size: Int,
        currentPosition: Int
    ) {

        linearLayout.removeAllViews()


        populateCardIndicators(activity, linearLayout, size, currentPosition)
    }

    fun populateCardIndicators(
        activity: Activity,
        linearLayout: LinearLayout,
        size: Int,
        currentPosition: Int
    ) {
        Log.d(TAG, "populateCardIndicators: wow")
        val dots = ArrayList<ImageView>()

        for (i in 0 until size) {
            val v = ImageView(this)
            val widthHeight: Int = convertDpToPx(8)
            v.apply {
                layoutParams = getParams(widthHeight, widthHeight)
                setImageResource(R.drawable.shape_circle_white)
                setColorFilter(
                    ContextCompat.getColor(activity, R.color.teal_700),
                    PorterDuff.Mode.SRC_ATOP
                )
            }
            dots.add(v)

            if (i == currentPosition) {
                val height: Int = convertDpToPx(8)
                val width: Int = convertDpToPx(15)
                dots[currentPosition].apply {
                    setImageResource(R.drawable.shape_selected)
                    layoutParams = getParams(width, height)
                    setColorFilter(
                        ContextCompat.getColor(activity, R.color.teal_700),
                        PorterDuff.Mode.SRC_ATOP
                    )
                }
            }
            linearLayout.addView(dots[i])
        }
    }
}