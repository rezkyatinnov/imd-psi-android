package com.rezkyatinnov.imdpsi

import android.app.Application
import android.content.Context
import com.rezkyatinnov.kyandroid.Kyandroid
import com.rezkyatinnov.kyandroid.localdata.KyandroidRealmModule
import com.rezkyatinnov.imdpsi.rest.RestServices

/**
 * Created by rezkyatinnov on 30/10/2017.
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Kyandroid.setDbKey(BuildConfig.DB_KEY)
        Kyandroid.init(this,
                BuildConfig.BASE_URL, RestServices::class.java,
                BuildConfig.SHARED_PREF_NAME, Context.MODE_PRIVATE,
                BuildConfig.SCHEMA_NAME,
                BuildConfig.SCHEMA_VERSION.toLong(),
                true,
                KyandroidRealmModule())
    }
}