package com.example.e4clinic.ui.fragments

import androidx.fragment.app.viewModels
import com.example.e4clinic.R
import com.example.e4clinic.databinding.FragmentMoreBinding
import com.example.e4clinic.ui.core.BaseFragment
import com.example.e4clinic.ui.core.BaseViewModel
import com.example.e4clinic.BR

class MoreFragment : BaseFragment<BaseViewModel, FragmentMoreBinding>() {
    private lateinit var mViewBinding: FragmentMoreBinding
    override fun getBindingVariable(): Int = BR.viewModel
    private val mViewModel: BaseViewModel by viewModels()
    override fun getViewModel(): BaseViewModel = mViewModel
    override fun getLayoutId(): Int=
        R.layout.fragment_more
}