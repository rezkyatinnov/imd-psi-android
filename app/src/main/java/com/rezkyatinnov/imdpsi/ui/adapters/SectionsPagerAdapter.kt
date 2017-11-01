package com.rezkyatinnov.imdpsi.ui.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.rezkyatinnov.imdpsi.ui.fragments.Chart24Fragment
import com.rezkyatinnov.imdpsi.ui.fragments.MapFragment
import com.rezkyatinnov.imdpsi.ui.fragments.PlaceholderFragment

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 *
 * Created by rezkyatinnov on 31/10/2017.
 */
class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> {
                return MapFragment()
            }
            1 -> {
                return Chart24Fragment()
            }
            else -> {
                return PlaceholderFragment.newInstance(position + 1)
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        when(position){
            0 -> {
                return "Map"
            }
            1 -> {
                return "24hrs PSI"
            }
            else -> {
                return "PSI"
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }
}