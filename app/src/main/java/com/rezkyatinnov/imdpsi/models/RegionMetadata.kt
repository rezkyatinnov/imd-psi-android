package com.rezkyatinnov.imdpsi.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject

/**
 * Created by rezkya on 10/31/17.
 */
open class RegionMetadata(
        @SerializedName("name")
        @Expose
        var name: String? = null,
        @SerializedName("label_location")
        @Expose
        var location: Location? = null
): RealmObject()