package com.test.dtac.ui


import android.content.Intent
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.facebook.*
import com.facebook.login.LoginResult
import com.test.dtac.R
import com.test.dtac.base.BaseActivity
import com.test.dtac.databinding.ActivityMainBinding
import com.test.dtac.extension.toJsonString
import com.test.dtac.ui.adapter.UserFeedRecyclerAdapter

/**
 * Created by PrewSitthirat on 10/3/2020 AD.
 */

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(MainViewModel::class) {

    override var layoutResource: Int = R.layout.activity_main
    private lateinit var callbackManager: CallbackManager
    private lateinit var recyclerAdapter: UserFeedRecyclerAdapter

    override fun initInstance() {
        super.initInstance()
        initRecyclerFeed()
        initCallbackManager()
        setReadPermission()
        initAccessTokenTracker()
    }

    override fun subscribeLiveData() {
        super.subscribeLiveData()
        mViewModel.feedLiveData.observe(this, Observer {
            binding.progressBar.visibility = View.GONE
            binding.recyclerFeed.visibility = View.VISIBLE
            Log.d("response", it.toJsonString())
            recyclerAdapter.feedList = it
            recyclerAdapter.notifyDataSetChanged()
        })
    }

    override fun proceedFlow() {
        super.proceedFlow()
        if (AccessToken.getCurrentAccessToken() != null) {
            if (!AccessToken.getCurrentAccessToken().isExpired) {
                callGraphRequestUserFeeds(AccessToken.getCurrentAccessToken())
            }
        }
    }

    private fun initRecyclerFeed() {
        recyclerAdapter = UserFeedRecyclerAdapter()
        binding.recyclerFeed.apply {
            adapter = recyclerAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
        }
    }

    private fun initCallbackManager() {
        callbackManager = CallbackManager.Factory.create()
    }

    private fun setReadPermission() {
        binding.btnLoginFacebook.setPermissions(arrayListOf("user_posts"))
        binding.btnLoginFacebook.registerCallback(callbackManager, object : FacebookCallback<LoginResult?> {
            override fun onSuccess(result: LoginResult?) {
                Log.d("Prew", "onSuccess")
                result?.let {
                    callGraphRequestUserFeeds(it.accessToken)
                }
            }

            override fun onCancel() {
                Log.d("Prew", "onCancel")
            }

            override fun onError(error: FacebookException?) {
                Log.d("Prew", "onError")
                Log.d("Prew", error?.message ?: "")
            }
        })
    }

    private fun initAccessTokenTracker() {
        val accessTokenTracker = object : AccessTokenTracker() {
            override fun onCurrentAccessTokenChanged(oldAccessToken: AccessToken?, currentAccessToken: AccessToken?) {
                if (currentAccessToken == null) {
                    mViewModel.feedLiveData.postValue(arrayListOf())
                }
            }
        }
    }

    private fun callGraphRequestUserFeeds(accessToken: AccessToken) {
        binding.progressBar.visibility = View.VISIBLE
        binding.recyclerFeed.visibility = View.GONE
        mViewModel.callGraphRequestUserFeeds(accessToken)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }
}
