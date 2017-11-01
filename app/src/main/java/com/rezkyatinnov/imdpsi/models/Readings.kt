package com.rezkyatinnov.imdpsi.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import java.lang.reflect.Modifier
import java.util.HashMap

/**
 * Created by rezkya on 10/31/17.
 */
open class Readings(
        @SerializedName("o3_sub_index")
        @Expose
        var o3SubIndex: Reading? = null,
        @SerializedName("pm10_twenty_four_hourly")
        @Expose
        var pm10TwentyFourHourly: Reading? = null,
        @SerializedName("pm10_sub_index")
        @Expose
        var pm10SubIndex: Reading? = null,
        @SerializedName("co_sub_index")
        @Expose
        var coSubIndex: Reading? = null,
        @SerializedName("pm25_twenty_four_hourly")
        @Expose
        var pm25TwentyFourHourly: Reading? = null,
        @SerializedName("so2_sub_index")
        @Expose
        var so2SubIndex: Reading? = null,
        @SerializedName("co_eight_hour_max")
        @Expose
        var coEightHourMax: Reading? = null,
        @SerializedName("no2_one_hour_max")
        @Expose
        var no2OneHourMax: Reading? = null,
        @SerializedName("so2_twenty_four_hourly")
        @Expose
        var so2TwentyFourHourly: Reading? = null,
        @SerializedName("pm25_sub_index")
        @Expose
        var pm25SubIndex: Reading? = null,
        @SerializedName("psi_twenty_four_hourly")
        @Expose
        var psiTwentyFourHourly: Reading? = null,
        @SerializedName("o3_eight_hour_max")
        @Expose
        var o3EightHourMax: Reading? = null
): RealmObject() {
        
        fun getPsiByRegion(region: String): HashMap<String, Double> {
                val psiRegion = HashMap<String, Double>()
                val fields = javaClass.declaredFields
                for (field in fields) {
                        if (field.type.isAssignableFrom(Reading::class.java)) {
                                try {
                                        val reading = field.get(this) as Reading
                                        psiRegion.put(field.name, reading.getRegionValue(region))
                                } catch (e: IllegalAccessException) {
                                        e.printStackTrace()
                                }

                        }
                }
                return psiRegion
        }
        
        fun toString(region:String):String{
                var result = ""
                result = result + "o3_sub_index : " + o3SubIndex!!.getRegionValue(region) + "\n"
                result = result + "pm10_twenty_four_hourly : " + pm10TwentyFourHourly!!.getRegionValue(region) + "\n"
                result = result + "pm10_sub_index : " + pm10SubIndex!!.getRegionValue(region) + "\n"
                result = result + "co_sub_index : " + coSubIndex!!.getRegionValue(region) + "\n"
                result = result + "pm25_twenty_four_hourly : " + pm25TwentyFourHourly!!.getRegionValue(region) + "\n"
                result = result + "so2_sub_index : " + so2SubIndex!!.getRegionValue(region) + "\n"
                result = result + "co_eight_hour_max : " + coEightHourMax!!.getRegionValue(region) + "\n"
                result = result + "no2_one_hour_max : " + no2OneHourMax!!.getRegionValue(region) + "\n"
                result = result + "so2_twenty_four_hourly : " + so2TwentyFourHourly!!.getRegionValue(region) + "\n"
                result = result + "pm25_sub_index : " + pm25SubIndex!!.getRegionValue(region) + "\n"
                result = result + "psi_twenty_four_hourly : " + psiTwentyFourHourly!!.getRegionValue(region) + "\n"
                result = result + "o3_eight_hour_max : " + o3EightHourMax!!.getRegionValue(region) + "\n"

                return result
        }
}