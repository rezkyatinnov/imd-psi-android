package com.rezkyatinnov.imdpsi.ui.activities

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import com.rezkyatinnov.kyandroid.session.SessionObject

/**
 * Created by rezkyatinnov on 31/10/2017.
 */
class SplashActivity  : AppCompatActivity() {

    lateinit var session: SessionObject

    override fun onCreate(savedInstanceState: Bundle? ) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w = window // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        }
        Handler().postDelayed({
                    val intent = Intent(this@SplashActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
        }, 2000)

    }
}