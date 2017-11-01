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
        @PrimaryKey
        open var type: Int? = PsiType.TYPE_DATETIME,
        @SerializedName("region_metadata")
        @Expose
        var regionMetadata: RealmList<RegionMetadata>? = null,
        @SerializedName("items")
        @Expose
        var items: RealmList<Item>? = null,
        @SerializedName("api_info")
        @Expose
        var apiInfo: ApiInfo? = null
): RealmObject(){
        object PsiType {
                val TYPE_DATE = 0
                val TYPE_DATETIME = 1
                val TYPE_FIELD_NAME = "type"
        }
}