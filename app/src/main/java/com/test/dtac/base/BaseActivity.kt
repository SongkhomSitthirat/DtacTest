package com.test.dtac.base

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.reflect.KClass

/**
 * Created by PrewSitthirat on 10/3/2020 AD.
 */

abstract class BaseActivity<B : ViewDataBinding, out VM : BaseViewModel>(clazz: KClass<VM>) : AppCompatActivity(),
    View.OnClickListener {

    protected lateinit var binding: B
    abstract var layoutResource: Int
    protected val mViewModel: VM by viewModel(clazz)
    protected val mHandler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutResource)
        initInstance()
        subscribeLiveData()
        if (savedInstanceState == null) {
            proceedFlow()
        }
    }

    open fun initInstance() {

    }

    open fun subscribeLiveData() {

    }

    open fun proceedFlow() {

    }

    override fun onPause() {
        super.onPause()
        mHandler.removeCallbacksAndMessages(null)
    }

    override fun onClick(view: View) {
    }
}