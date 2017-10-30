package com.rezkyatinnov.imdpsi.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by rezkya on 10/31/17.
 */
data class RegionMetadata(
        @SerializedName("name")
        @Expose
        private var name: String? = null,
        @SerializedName("label_location")
        @Expose
        private var location: Location? = null
)