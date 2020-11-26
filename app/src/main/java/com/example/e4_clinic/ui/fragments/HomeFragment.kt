package com.example.e4_clinic.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.e4_clinic.R
import com.example.e4_clinic.databinding.FragmentHomeBinding
import com.example.e4_clinic.databinding.FragmentLoginBinding
import com.example.e4_clinic.ui.core.BaseFragment
import com.example.e4_clinic.ui.core.BaseViewModel

class HomeFragment :  BaseFragment<BaseViewModel, FragmentHomeBinding>(BaseViewModel::class.java) {
    override fun getLayoutRes(): Int = R.layout.fragment_home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        return super.onCreateView(inflater, container, savedInstanceState)
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.toolbar_menu, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {

        }
        return super.onOptionsItemSelected(item)
    }
}