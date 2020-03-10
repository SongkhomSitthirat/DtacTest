package com.test.dtac.base

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.reflect.KClass

/**
 * Created by PrewSitthirat on 10/3/2020 AD.
 */

abstract class BaseFragment<B : ViewDataBinding, out VM : BaseViewModel>(clazz: KClass<VM>) : Fragment(), View.OnClickListener {

    protected lateinit var binding: B
    abstract var layoutResource: Int
    protected val mViewModel: VM by viewModel(clazz)
    protected lateinit var mActivity: FragmentActivity
    protected val mHandler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getDataFromArguments(arguments ?: Bundle())
    }

    open fun getDataFromArguments(arguments: Bundle) {

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mActivity = activity!!
        binding = DataBindingUtil.inflate(inflater, layoutResource, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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

    override fun onClick(view: View?) {
    }
}