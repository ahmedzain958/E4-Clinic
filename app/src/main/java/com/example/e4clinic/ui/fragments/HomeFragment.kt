package com.example.e4clinic.ui.fragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.e4clinic.R
import com.example.e4clinic.databinding.FragmentHomeBinding
import com.example.e4clinic.other.E4ClinicUtility.getCurrentMonthYear
import com.example.e4clinic.ui.core.BaseFragment
import com.example.e4clinic.ui.core.BaseViewModel
import org.joda.time.DateTime
import com.example.e4clinic.BR
import com.example.e4clinic.ui.viewmodel.ClinicsViewModel
import com.example.e4clinic.ui.viewmodel.HomeViewModel


class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {
    private lateinit var mBinding: FragmentHomeBinding
    override fun getBindingVariable(): Int = BR.viewModel
    override fun getLayoutId(): Int=
        R.layout.fragment_home
    private val mViewModel: HomeViewModel by viewModels()
    override fun getViewModel(): HomeViewModel = mViewModel


    private fun initListeners() {
        mBinding.calenderWeek.setOnDateClickListener { dateTime: DateTime ->
            mBinding.txtMonthYear.text = getCurrentMonthYear(dateTime)
        }
        mBinding.cardviewClinics.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_clinicsFragment)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mBinding = getViewDataBinding()
        initListeners()
        mBinding.txtMonthYear.text = getCurrentMonthYear()
        super.onViewCreated(view, savedInstanceState)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.toolbar_menu, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

        }
        return super.onOptionsItemSelected(item)
    }
}