package com.test.dtac.ui

import androidx.lifecycle.MutableLiveData
import com.facebook.AccessToken
import com.facebook.GraphRequest
import com.facebook.HttpMethod
import com.google.gson.Gson
import com.test.dtac.base.BaseViewModel
import com.test.dtac.extension.fromJson
import com.test.dtac.model.ResponseModel
import com.test.dtac.model.response.UseFeedModel

/**
 * Created by PrewSitthirat on 10/3/2020 AD.
 */

class MainViewModel : BaseViewModel() {

    val feedLiveData: MutableLiveData<ArrayList<UseFeedModel>> = MutableLiveData()

    fun callGraphRequestUserFeeds(accessToken: AccessToken) {
        GraphRequest(accessToken, "/me/feed", null,
                HttpMethod.GET, GraphRequest.Callback {
            val response: ResponseModel<ArrayList<UseFeedModel>> = Gson().fromJson(it.jsonObject.toString())
            feedLiveData.postValue(response.data ?: arrayListOf())
        }).executeAsync()
    }
}