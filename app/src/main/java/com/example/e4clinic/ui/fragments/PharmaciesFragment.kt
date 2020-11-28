package com.example.e4clinic.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e4clinic.BR
import com.example.e4clinic.R
import com.example.e4clinic.databinding.FragmentPharmaciesBinding
import com.example.e4clinic.models.Pharmacy
import com.example.e4clinic.other.E4ClinicUtility
import com.example.e4clinic.ui.adapters.PharmaciesAdapter
import com.example.e4clinic.ui.core.BaseFragment
import com.example.e4clinic.ui.viewmodel.PharmaciesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PharmaciesFragment :
    BaseFragment<PharmaciesViewModel, FragmentPharmaciesBinding>() {
    private lateinit var adapter: PharmaciesAdapter
    private val mViewModel: PharmaciesViewModel by viewModels()
    override fun getViewModel(): PharmaciesViewModel = mViewModel
    private lateinit var mViewBinding: FragmentPharmaciesBinding
    override fun getBindingVariable(): Int = BR.viewModel
    override fun getLayoutId(): Int =
        R.layout.fragment_pharmacies

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        mViewBinding = getViewDataBinding()
        setupRecyclerView()
        subscribeObservers()
        initListeners()
        mViewModel.getPharmacies()
        mViewBinding.txtMonthYear.text = E4ClinicUtility.getCurrentMonthYear()
    }

    private fun initListeners() {
        /* mViewBinding.calenderWeek.setOnDateClickListener { dateTime: DateTime ->
             mViewBinding.txtMonthYear.text = E4ClinicUtility.getCurrentMonthYear(dateTime)
         }*/
    }


    private fun setupRecyclerView() {
        mViewBinding.recyclerPharmacies.layoutManager = LinearLayoutManager(requireActivity())
        adapter = PharmaciesAdapter()
        mViewBinding.recyclerPharmacies.addItemDecoration(
            DividerItemDecoration(
                mViewBinding.recyclerPharmacies.context,
                (mViewBinding.recyclerPharmacies.layoutManager as LinearLayoutManager).orientation
            )
        )
        mViewBinding.recyclerPharmacies.adapter = adapter
    }

    private fun subscribeObservers() {
        mViewModel.pharmacies.observe(viewLifecycleOwner, { pharmaciesList: List<Pharmacy> ->
            populateRecyclerView(pharmaciesList)
        })
    }

    private fun populateRecyclerView(pharmaciesList: List<Pharmacy>) {
        if (!pharmaciesList.isNullOrEmpty()) adapter.setItems(pharmaciesList)
    }
}