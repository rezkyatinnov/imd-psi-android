package com.rezkyatinnov.imdpsi.ui.activities

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import com.rezkyatinnov.imdpsi.models.Psi
import com.rezkyatinnov.imdpsi.rest.PsiHelper
import com.rezkyatinnov.kyandroid.localdata.LocalData
import com.rezkyatinnov.kyandroid.localdata.QueryFilters
import com.rezkyatinnov.kyandroid.reztrofit.ErrorResponse
import com.rezkyatinnov.kyandroid.reztrofit.RestObserver
import com.rezkyatinnov.kyandroid.ui.utils.AlertUtils
import io.reactivex.disposables.Disposable
import okhttp3.Headers

/**
 * Created by rezkyatinnov on 31/10/2017.
 *
 */
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w = window
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        }

        loadingPsiData()
    }

    private fun loadingPsiData(){

        PsiHelper.getPsiThisDate(object : RestObserver<Psi>() {
            override fun onSubscribe(d: Disposable) {
            }

            override fun onSuccess(headers: Headers?, body: Psi?) {
                LocalData.saveOrUpdate(body)
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }

            override fun onComplete() {
            }

            override fun onFailed(error: ErrorResponse?) {
                var filter = QueryFilters()
                filter.add(Psi.PsiType.TYPE_FIELD_NAME,Psi.PsiType.TYPE_DATE)
                try {
                    LocalData.get(filter, Psi::class.java) // check if app has localdata
                    val intent = Intent(this@SplashActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }catch(e:Exception) {
                    AlertUtils.showDialogDualActions(
                            this@SplashActivity,
                            "Ouch!",
                            "Retrieving data from server failed. Local Data not available",
                            "TRY AGAIN",
                            "EXIT",
                            { _, _ ->
                                loadingPsiData()
                            },
                            { _, _ ->
                                finish()
                            })
                }
            }

        })
    }
}