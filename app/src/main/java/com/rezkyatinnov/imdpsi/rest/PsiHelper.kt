package com.rezkyatinnov.imdpsi.rest

import com.rezkyatinnov.imdpsi.models.Psi
import com.rezkyatinnov.kyandroid.reztrofit.RestObserver
import com.rezkyatinnov.kyandroid.reztrofit.Reztrofit
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by rezkyatinnov on 31/10/2017.
 */
class PsiHelper {
    fun getPsi(datetime:String,date:String,observer: RestObserver<Psi>){
        val service = Reztrofit.getInstance() as Reztrofit<RestServices>
        val rest = service.endpoint.getPsi(datetime,date)
        rest.subscribeOn(
                Schedulers.newThread()
        ).observeOn(
                AndroidSchedulers.mainThread()
        ).subscribe({ observer })
    }
}