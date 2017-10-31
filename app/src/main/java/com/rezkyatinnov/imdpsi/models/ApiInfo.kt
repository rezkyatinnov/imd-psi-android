package com.rezkyatinnov.imdpsi.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by rezkya on 10/31/17.
 */
data class ApiInfo(
        @SerializedName("status")
        @Expose
        var status: String? = null
)