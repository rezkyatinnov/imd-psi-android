package com.rezkyatinnov.imdpsi.ui.fragments

import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.rezkyatinnov.imdpsi.R
import com.rezkyatinnov.imdpsi.models.Psi
import com.rezkyatinnov.imdpsi.models.Readings
import com.rezkyatinnov.imdpsi.models.RegionMetadata
import com.rezkyatinnov.imdpsi.rest.PsiHelper
import com.rezkyatinnov.kyandroid.reztrofit.ErrorResponse
import com.rezkyatinnov.kyandroid.reztrofit.RestObserver
import io.reactivex.disposables.Disposable
import okhttp3.Headers

/**
 * Created by rezkyatinnov on 31/10/2017.
 *
 */
class MapFragment: Fragment(), OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private var googleMap: GoogleMap? = null
    private var readings: Readings? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_map, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initMapFragment()
    }

    private fun initMapFragment() {
        var supportMapFragment: SupportMapFragment? = childFragmentManager.findFragmentById(R.id.map_container) as SupportMapFragment
        if (supportMapFragment == null) {
            supportMapFragment = SupportMapFragment.newInstance()
            childFragmentManager.beginTransaction().replace(R.id.map_container, supportMapFragment).commit()
        }
        supportMapFragment!!.getMapAsync(this)
    }

    private fun pinLocationMarker(title: String, location: LatLng) {
        if (googleMap != null) {
            val marker = MarkerOptions()
                    .position(location)
                    .icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(resources, R.drawable.ic_location_on)))
                    .title(title)
            googleMap!!.addMarker(marker)
        }
    }

    private fun getPsiDataFromApi() {
        PsiHelper.getPsi(object:RestObserver<Psi>(){
            override fun onComplete() {
            }

            override fun onFailed(error: ErrorResponse?) {
                Toast.makeText(activity, error?.message, Toast.LENGTH_SHORT).show()
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onSuccess(headers: Headers?, body: Psi?) {
                readings = body?.items!![0].readings
                activity.runOnUiThread { setRegionalMetaDataLocation(body.regionMetadata!!) }
            }
        })
    }

    private fun setRegionalMetaDataLocation(metaDataLocation: ArrayList<RegionMetadata>) {
        for (regionMetadata in metaDataLocation) {
            pinLocationMarker(regionMetadata.name!!, LatLng(regionMetadata.location?.latitude!!,regionMetadata.location?.longitude!!))
        }
    }

    override fun onConnected(bundle: Bundle?) {}

    override fun onConnectionSuspended(i: Int) {
        Toast.makeText(activity, "Map connection suspended", Toast.LENGTH_SHORT).show()
    }

    override fun onConnectionFailed(connectionResult: ConnectionResult) {
        Toast.makeText(activity, connectionResult.errorMessage, Toast.LENGTH_SHORT).show()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        this.googleMap = googleMap
        val singaporeLatLng = LatLng(1.3659974, 103.8533953)
        val singaporeBound = LatLngBounds(LatLng(1.1637, 103.5921333), LatLng(1.46145, 104.0828713))
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(singaporeLatLng, 10.5f))
        googleMap.setLatLngBoundsForCameraTarget(singaporeBound)
        getPsiDataFromApi()
    }
}