package com.rezkyatinnov.imdpsi.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject

/**
 * Created by rezkya on 10/31/17.
 */
open class Item(
        @SerializedName("timestamp")
        @Expose
        var timestamp: String? = null,
        @SerializedName("update_timestamp")
        @Expose
        var updateTimestamp: String? = null,
        @SerializedName("readings")
        @Expose
        var readings: Readings? = null
): RealmObject()