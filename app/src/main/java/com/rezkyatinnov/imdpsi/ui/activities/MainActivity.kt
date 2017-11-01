package com.rezkyatinnov.imdpsi.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.rezkyatinnov.imdpsi.R
import com.rezkyatinnov.imdpsi.ui.adapters.SectionsPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        container.adapter = mSectionsPagerAdapter
        tablayout.setViewPager(container)

    }

}
