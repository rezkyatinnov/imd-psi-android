package com.rezkyatinnov.imdpsi.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by rezkya on 10/31/17.
 */
data class Item(

        @SerializedName("timestamp")
        @Expose
        private var timestamp: String? = null,
        @SerializedName("update_timestamp")
        @Expose
        private var updateTimestamp: String? = null,
        @SerializedName("readings")
        @Expose
        private var psiReadings: PsiReadings? = null
)