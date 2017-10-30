package com.rezkyatinnov.imdpsi.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by rezkya on 10/31/17.
 */
data class Psi (
        @SerializedName("region_metadata")
        @Expose
        private var regionMetadata: ArrayList<RegionMetadata>? = null,
        @SerializedName("items")
        @Expose
        private var psiItems: ArrayList<Item>? = null,
        @SerializedName("api_info")
        @Expose
        private var apiInfo: ApiInfo? = null
)