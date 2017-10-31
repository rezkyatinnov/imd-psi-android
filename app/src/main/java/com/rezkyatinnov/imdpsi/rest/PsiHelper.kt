package com.rezkyatinnov.imdpsi.rest

import android.util.Log
import com.rezkyatinnov.imdpsi.models.Psi
import com.rezkyatinnov.kyandroid.reztrofit.RestObserver
import com.rezkyatinnov.kyandroid.reztrofit.Reztrofit
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by rezkyatinnov on 31/10/2017.
 */
object PsiHelper {
    fun getPsi(observer: RestObserver<Psi>){

        val df = SimpleDateFormat("yyyy-MM-dd")
        val dfTime = SimpleDateFormat("hh:mm:ss")
        val date = df.format(Date())
        val time = dfTime.format(Date())

        val service = Reztrofit.getInstance() as Reztrofit<RestServices>
        val rest = service.endpoint.getPsi(date+"T"+time,"")
        rest.subscribeOn(
                Schedulers.newThread()
        ).observeOn(
                AndroidSchedulers.mainThread()
        ).subscribe(observer)
    }
}