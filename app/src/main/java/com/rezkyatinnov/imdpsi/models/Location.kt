package com.rezkyatinnov.imdpsi.models

import com.google.android.gms.maps.model.LatLng
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by rezkya on 10/31/17.
 */
data class Location(
        @SerializedName("name")
        @Expose
        private var latitude: Double? = 0.0,
        @SerializedName("name")
        @Expose
        private var longitude: Double? = 0.0,
        @SerializedName("name")
        @Expose
        private var latLng: LatLng? = null
)