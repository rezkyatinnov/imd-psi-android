package com.rezkyatinnov.imdpsi

import android.support.test.filters.SmallTest
import android.support.test.runner.AndroidJUnit4
import com.rezkyatinnov.imdpsi.models.Psi
import com.rezkyatinnov.imdpsi.rest.RestServices
import com.rezkyatinnov.kyandroid.reztrofit.ErrorResponse
import com.rezkyatinnov.kyandroid.reztrofit.RestObserver
import com.rezkyatinnov.kyandroid.reztrofit.Reztrofit
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.Headers
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.mock.MockRetrofit
import retrofit2.mock.NetworkBehavior

/**
 * Created by rezkyatinnov on 31/10/2017.
 */
@RunWith(AndroidJUnit4::class)
@SmallTest
class PsiRestTest {
    private var mockRetrofit: MockRetrofit? = null

    @Before
    fun init(){
        val behavior = NetworkBehavior.create()

        mockRetrofit = MockRetrofit.Builder(Reztrofit.getInstance().retrofit)
                .networkBehavior(behavior)
                .build()
    }

    @Test
    fun testGetPsiRestCall() {
        val delegate = mockRetrofit?.create(RestServices::class.java)
        val mockPsiRestService = MockPsiRestService(delegate!!)

        //Actual Test
        val psi = mockPsiRestService.getPsi("2017-10-30T09:45:00","")
        psi.subscribeOn(
                Schedulers.newThread()
        ).observeOn(
                AndroidSchedulers.mainThread()
        ).subscribe(object:RestObserver<Psi>(){
            override fun onFailed(error: ErrorResponse?) {

            }

            override fun onSuccess(headers: Headers?, body: Psi?) {
                assertNotNull(body!!.regionMetadata)
                assertNotNull(body.items)
                assertNotNull(body.items!![0]!!.timestamp)
                assertEquals(1, body.items!!.size)
                assertEquals("2017-10-30T09:45:00", body.items!![0]!!.timestamp)
            }

            override fun onComplete() {

            }

            override fun onSubscribe(d: Disposable) {

            }

        })

    }
}