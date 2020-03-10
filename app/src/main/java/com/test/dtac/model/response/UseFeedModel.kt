package com.test.dtac.model.response

import com.google.gson.annotations.SerializedName

/**
 * Created by PrewSitthirat on 10/3/2020 AD.
 */

data class UseFeedModel(
        @SerializedName("message")
        val message: String? = "",
        @SerializedName("created_time")
        val createdTime: String? = "",
        @SerializedName("id")
        val id: String? = ""
)