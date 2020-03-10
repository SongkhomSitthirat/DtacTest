package com.test.dtac.template

import android.os.Bundle
import android.view.View
import com.test.dtac.R
import com.test.dtac.base.BaseFragment
import com.test.dtac.databinding.FragmentTemplateBinding

/**
 * Created by PrewSitthirat on 10/3/2020 AD.
 */

class TemplateFragment : BaseFragment<FragmentTemplateBinding, TemplateViewModel>(TemplateViewModel::class) {

    override var layoutResource: Int = R.layout.fragment_template

    companion object {
        fun newInstance(): TemplateFragment {
            return TemplateFragment().apply {
                arguments = Bundle().apply {
                }
            }
        }
    }

    override fun getDataFromArguments(arguments: Bundle) {
        super.getDataFromArguments(arguments)
    }

    override fun initInstance() {
        super.initInstance()
    }

    override fun subscribeLiveData() {
        super.subscribeLiveData()
    }

    override fun proceedFlow() {
        super.proceedFlow()
    }

    override fun onClick(view: View?) {
        super.onClick(view)
        when (view?.id) {

        }
    }
}