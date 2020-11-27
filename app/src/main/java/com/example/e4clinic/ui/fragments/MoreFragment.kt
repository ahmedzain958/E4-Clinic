package com.example.e4clinic.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.e4clinic.R
import com.example.e4clinic.databinding.FragmentHomeBinding
import com.example.e4clinic.databinding.FragmentMoreBinding
import com.example.e4clinic.ui.core.BaseFragment
import com.example.e4clinic.ui.core.BaseViewModel

class MoreFragment : BaseFragment<BaseViewModel, FragmentMoreBinding>(BaseViewModel::class.java) {
    override fun getLayoutRes(): Int = R.layout.fragment_more

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState)
    }


}