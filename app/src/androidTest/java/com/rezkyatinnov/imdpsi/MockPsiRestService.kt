package com.rezkyatinnov.imdpsi

import com.google.android.gms.maps.model.LatLng
import com.rezkyatinnov.imdpsi.models.*
import com.rezkyatinnov.imdpsi.rest.RestServices
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.mock.BehaviorDelegate

/**
 * Created by rezkyatinnov on 31/10/2017.
 */
class MockPsiRestService(val delegate: BehaviorDelegate<RestServices>) : RestServices {
    override fun getPsi(dateTime: String, date: String): Observable<Response<Psi>> {
        var regionMetadatas = ArrayList<RegionMetadata>()
        regionMetadatas.add(RegionMetadata("west", Location(1.35735, 103.7, LatLng(1.35735, 103.7))))
        regionMetadatas.add(RegionMetadata("national", Location(0.0, 0.0, LatLng(0.0, 0.0))))
        regionMetadatas.add(RegionMetadata("east", Location(1.35735, 103.94, LatLng(1.35735, 103.94))))
        regionMetadatas.add(RegionMetadata("central", Location(1.35735, 103.82, LatLng(1.35735, 103.82))))
        regionMetadatas.add(RegionMetadata("south", Location(1.29587, 103.82, LatLng(1.29587, 103.82))))
        regionMetadatas.add(RegionMetadata("north", Location(1.41803, 103.82, LatLng(1.41803, 103.82))))

        var items = ArrayList<Item>()
        items.add(
                Item(
                        "2017-10-30T09:00:00+08:00",
                        "2017-10-30T09:06:18+08:00",
                        Readings(
                                Reading(12.0,12.0,5.0,4.0,4.0,3.0),
                                Reading(18.0,32.0,32.0,22.0,22.0,23.0),
                                Reading(18.0,32.0,32.0,22.0,22.0,23.0),
                                Reading(6.0,8.0,5.0,8.0,8.0,7.0),
                                Reading(8.0,16.0,16.0,12.0,13.0,12.0),
                                Reading(3.0,5.0,5.0,5.0,4.0,4.0),
                                Reading(0.6,0.81,0.46,0.77,0.81,0.74),
                                Reading(6.0,37.0,35.0,37.0,15.0,37.0),
                                Reading(5.0,8.0,8.0,8.0,7.0,6.0),
                                Reading(33.0,55.0,55.0,51.0,52.0,49.0),
                                Reading(33.0,55.0,55.0,51.0,52.0,49.0),
                                Reading(28.0,28.0,12.0,9.0,9.0,6.0)
                        )
                )
        )

        val apiInfo = ApiInfo("healthy")

        var psi = Psi(regionMetadatas, items, apiInfo)

        return delegate.returningResponse(Response.success(psi)).getPsi(dateTime, date)
    }
}