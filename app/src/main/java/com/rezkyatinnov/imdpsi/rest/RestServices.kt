package com.rezkyatinnov.imdpsi.rest

import com.rezkyatinnov.imdpsi.models.Psi
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * Created by rezkyatinnov on 30/10/2017.
 *
 * All endpoint services defined here using retrofit interface style
 */
interface RestServices {
    @Headers("Accept: application/json")
    @GET("environment/psi")
    fun getPsi(@Query("date_time") dateTime: String?, @Query("date") date: String?): Observable<Response<Psi>>
}