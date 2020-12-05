package com.example.e4clinic.ui.fragments.client

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.e4clinic.BR
import com.example.e4clinic.R
import com.example.e4clinic.databinding.FragmentAddClientBinding
import com.example.e4clinic.ui.core.BaseFragment
import com.example.e4clinic.ui.viewmodel.AddClientViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddClientFragment :
    BaseFragment<AddClientViewModel, FragmentAddClientBinding>() {
    private val mViewModel: AddClientViewModel by viewModels()
    override fun getViewModel(): AddClientViewModel = mViewModel
    private lateinit var mViewBinding: FragmentAddClientBinding
    override fun getBindingVariable(): Int = BR.viewModel
    override fun getLayoutId(): Int =
        R.layout.fragment_add_client

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewBinding = getViewDataBinding()
        initListeners()
    }

    private fun initListeners() {
        mViewBinding.btnSave.setOnClickListener {
            findNavController().navigateUp()
        }
    }


}