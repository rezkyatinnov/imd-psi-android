package com.rezkyatinnov.imdpsi.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject

/**
 * Created by rezkya on 10/31/17.
 */
open class ApiInfo(
        @SerializedName("status")
        @Expose
        var status: String? = null
): RealmObject()