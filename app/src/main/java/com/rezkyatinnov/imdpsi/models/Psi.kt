package com.rezkyatinnov.imdpsi.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by rezkya on 10/31/17.
 */
open class Psi (
        @SerializedName("is_datetime")
        @Expose
        @PrimaryKey
        open var isDatetime: Int? = 1,
        @SerializedName("region_metadata")
        @Expose
        var regionMetadata: RealmList<RegionMetadata>? = null,
        @SerializedName("items")
        @Expose
        var items: RealmList<Item>? = null,
        @SerializedName("api_info")
        @Expose
        var apiInfo: ApiInfo? = null
): RealmObject()