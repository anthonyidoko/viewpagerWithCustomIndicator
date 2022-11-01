package com.example.myviewpager2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager,lifecycle) {
    private val TAG = "MyAdapter"
val items = listOf(1,2,3,4)
    override fun getItemCount(): Int {
        Log.d(TAG, "getItemCount: ${items.size}")
        return items.size
    }

    override fun createFragment(position: Int): Fragment {
//        when(position){
//            1 -> {
//                return FirstFragment()
//            }
//
//        }
        val fragment = FirstFragment()
        val bundle = Bundle()
        bundle.putString("KEY", "Tab ${position + 1}")
        fragment.arguments = bundle
        return fragment
    }
}