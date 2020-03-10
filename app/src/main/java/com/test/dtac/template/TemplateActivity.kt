package com.test.dtac.template

import android.view.View
import com.test.dtac.R
import com.test.dtac.base.BaseActivity
import com.test.dtac.databinding.ActivityTemplateBinding

/**
 * Created by PrewSitthirat on 10/3/2020 AD.
 */

class TemplateActivity : BaseActivity<ActivityTemplateBinding, TemplateViewModel>(TemplateViewModel::class) {

    override var layoutResource: Int = R.layout.activity_main

    override fun initInstance() {
        super.initInstance()
    }

    override fun subscribeLiveData() {
        super.subscribeLiveData()
    }

    override fun proceedFlow() {
        super.proceedFlow()
    }

    override fun onClick(view: View) {
        super.onClick(view)
        when (view.id) {

        }
    }
}