package com.example.e4clinic.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.e4clinic.BR
import com.example.e4clinic.R
import com.example.e4clinic.databinding.FragmentLoginBinding
import com.example.e4clinic.ui.core.BaseFragment
import com.example.e4clinic.ui.viewmodel.LoginViewModel


class LoginFragment : BaseFragment<LoginViewModel, FragmentLoginBinding>() {
    private lateinit var mBinding: FragmentLoginBinding
    override fun getBindingVariable(): Int = BR.viewModel
    override fun getLayoutId(): Int=
        R.layout.fragment_login
    private val mViewModel: LoginViewModel by viewModels()
    override fun getViewModel(): LoginViewModel = mViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding = getViewDataBinding()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        mBinding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }
}