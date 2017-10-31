package com.rezkyatinnov.imdpsi.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by rezkya on 10/31/17.
 */
class Reading(
        @SerializedName("west")
        @Expose
        var west: Double = 0.toDouble(),
        @SerializedName("national")
        @Expose
        var national: Double = 0.toDouble(),
        @SerializedName("east")
        @Expose
        var east: Double = 0.toDouble(),
        @SerializedName("central")
        @Expose
        var central: Double = 0.toDouble(),
        @SerializedName("south")
        @Expose
        var south: Double = 0.toDouble(),
        @SerializedName("north")
        @Expose
        var north: Double = 0.toDouble()
){
        fun getRegionValue(region: String): Double{
                when(region){
                        "west" -> return west
                        "national" -> return national
                        "east" -> return east
                        "central" -> return central
                        "south" -> return south
                        "north" -> return north
                        else -> return 0.0
                }

        }
}
