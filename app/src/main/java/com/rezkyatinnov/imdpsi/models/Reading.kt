package com.rezkyatinnov.imdpsi.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by rezkya on 10/31/17.
 */
class Reading(
        @SerializedName("west")
        @Expose
        private var west: Double = 0.toDouble(),
        @SerializedName("national")
        @Expose
        private var national: Double = 0.toDouble(),
        @SerializedName("east")
        @Expose
        private var east: Double = 0.toDouble(),
        @SerializedName("central")
        @Expose
        private var central: Double = 0.toDouble(),
        @SerializedName("south")
        @Expose
        private var south: Double = 0.toDouble(),
        @SerializedName("north")
        @Expose
        private var north: Double = 0.toDouble()
)
