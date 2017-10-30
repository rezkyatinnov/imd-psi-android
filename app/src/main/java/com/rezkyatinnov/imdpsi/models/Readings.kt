package com.rezkyatinnov.imdpsi.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by rezkya on 10/31/17.
 */
data class Readings(

        @SerializedName("o3_sub_index")
        @Expose
        private var o3SubIndex: Reading? = null,
        @SerializedName("pm10_twenty_four_hourly")
        @Expose
        private var pm10TwentyFourHourly: Reading? = null,
        @SerializedName("pm10_sub_index")
        @Expose
        private var pm10SubIndex: Reading? = null,
        @SerializedName("co_sub_index")
        @Expose
        private var coSubIndex: Reading? = null,
        @SerializedName("pm25_twenty_four_hourly")
        @Expose
        private var pm25TwentyFourHourly: Reading? = null,
        @SerializedName("so2_sub_index")
        @Expose
        private var so2SubIndex: Reading? = null,
        @SerializedName("co_eight_hour_max")
        @Expose
        private var coEightHourMax: Reading? = null,
        @SerializedName("no2_one_hour_max")
        @Expose
        private var no2OneHourMax: Reading? = null,
        @SerializedName("so2_twenty_four_hourly")
        @Expose
        private var so2TwentyFourHourly: Reading? = null,
        @SerializedName("pm25_sub_index")
        @Expose
        private var pm25SubIndex: Reading? = null,
        @SerializedName("psi_twenty_four_hourly")
        @Expose
        private var psiTwentyFourHourly: Reading? = null,
        @SerializedName("o3_eight_hour_max")
        @Expose
        private var o3EightHourMax: Reading? = null
)