package com.example.e4_clinic.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.e4_clinic.R
import com.example.e4_clinic.databinding.FragmentLoginBinding
import com.example.e4_clinic.ui.core.BaseFragment
import com.example.e4_clinic.ui.core.BaseViewModel


class LoginFragment : BaseFragment<BaseViewModel, FragmentLoginBinding>(BaseViewModel::class.java) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun getLayoutRes(): Int = R.layout.fragment_login
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }
    }

}