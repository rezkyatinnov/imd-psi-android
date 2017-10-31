package com.rezkyatinnov.imdpsi.rest

import com.rezkyatinnov.imdpsi.models.Psi
import com.rezkyatinnov.kyandroid.reztrofit.ErrorResponse
import com.rezkyatinnov.kyandroid.reztrofit.RestObserver
import com.rezkyatinnov.kyandroid.reztrofit.Reztrofit
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.Headers
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by rezkyatinnov on 31/10/2017.
 */
object PsiHelper {
    fun getPsiThisDateTime(observer: RestObserver<Psi>){

        val df = SimpleDateFormat("yyyy-MM-dd")
        val dfTime = SimpleDateFormat("hh:mm:ss")
        val date = df.format(Date())
        val time = dfTime.format(Date())

        val service = Reztrofit.getInstance() as Reztrofit<RestServices>
        val rest = service.endpoint.getPsi(date+"T"+time,null)
        rest.subscribeOn(
                Schedulers.newThread()
        ).observeOn(
                AndroidSchedulers.mainThread()
        ).subscribe(object:RestObserver<Psi>(){
            override fun onComplete() {
                observer.onComplete()
            }

            override fun onFailed(error: ErrorResponse?) {
                observer.onFailed(error)
            }

            override fun onSubscribe(d: Disposable) {
                observer.onSubscribe(d)
            }

            override fun onSuccess(headers: Headers?, body: Psi?) {
                body?.isDatetime = 1
                observer.onSuccess(headers,body)
            }

        })
    }

    fun getPsiThisDate(observer: RestObserver<Psi>){

        val df = SimpleDateFormat("yyyy-MM-dd")
        val date = df.format(Date())

        val service = Reztrofit.getInstance() as Reztrofit<RestServices>
        val rest = service.endpoint.getPsi(null,date)
        rest.subscribeOn(
                Schedulers.newThread()
        ).observeOn(
                AndroidSchedulers.mainThread()
        ).subscribe(object:RestObserver<Psi>(){
            override fun onComplete() {
                observer.onComplete()
            }

            override fun onFailed(error: ErrorResponse?) {
                observer.onFailed(error)
            }

            override fun onSubscribe(d: Disposable) {
                observer.onSubscribe(d)
            }

            override fun onSuccess(headers: Headers?, body: Psi?) {
                body?.isDatetime = 0
                observer.onSuccess(headers,body)
            }

        })
    }
}