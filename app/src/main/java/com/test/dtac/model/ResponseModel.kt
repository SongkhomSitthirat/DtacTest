package com.test.dtac.model

import com.google.gson.annotations.SerializedName

/**
 * Created by PrewSitthirat on 10/3/2020 AD.
 */

data class ResponseModel<T>(
        @SerializedName("data")
        val data: T?
)