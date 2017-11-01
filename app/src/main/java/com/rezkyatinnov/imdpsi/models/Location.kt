package com.rezkyatinnov.imdpsi.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject

/**
 * Created by rezkya on 10/31/17.
 */
open class Location(
        @SerializedName("latitude")
        @Expose
        var latitude: Double? = 0.0,
        @SerializedName("longitude")
        @Expose
        var longitude: Double? = 0.0
): RealmObject()