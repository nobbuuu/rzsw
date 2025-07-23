package com.blackview.base.common.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * @author : tiaozi
 * time : 2020/12/02 14:20
 */
class BaseFragmentPagerAdapter(fragmentActivity: FragmentActivity, private val mFragments: List<Fragment>) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = mFragments.size

    override fun createFragment(position: Int): Fragment = mFragments[position]

}