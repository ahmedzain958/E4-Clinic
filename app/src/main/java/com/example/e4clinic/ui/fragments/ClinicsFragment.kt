package com.example.e4clinic.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e4clinic.BR
import com.example.e4clinic.R
import com.example.e4clinic.databinding.FragmentClinicsBinding
import com.example.e4clinic.models.Clinic
import com.example.e4clinic.other.E4ClinicUtility
import com.example.e4clinic.ui.adapters.ClinicsAdapter
import com.example.e4clinic.ui.core.BaseFragment
import com.example.e4clinic.ui.viewmodel.ClinicsViewModel
import dagger.hilt.android.AndroidEntryPoint
import org.joda.time.DateTime

@AndroidEntryPoint
class ClinicsFragment :
    BaseFragment<ClinicsViewModel, FragmentClinicsBinding>() {
    private lateinit var adapter: ClinicsAdapter
    private val mViewModel: ClinicsViewModel by viewModels()
    override fun getViewModel(): ClinicsViewModel = mViewModel
    private lateinit var mViewBinding: FragmentClinicsBinding
    override fun getBindingVariable(): Int = BR.viewModel
    override fun getLayoutId(): Int =
        R.layout.fragment_clinics

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        mViewBinding = getViewDataBinding()
        setupRecyclerView()
        subscribeObservers()
        initListeners()
        mViewModel.getClinics()
        mViewBinding.txtMonthYear.text = E4ClinicUtility.getCurrentMonthYear()
    }

    private fun initListeners() {
       /* mViewBinding.calenderWeek.setOnDateClickListener { dateTime: DateTime ->
            mViewBinding.txtMonthYear.text = E4ClinicUtility.getCurrentMonthYear(dateTime)
        }*/
    }


    private fun setupRecyclerView() {
        mViewBinding.recyclerClinics.layoutManager = LinearLayoutManager(requireActivity())
        adapter = ClinicsAdapter()
        mViewBinding.recyclerClinics.addItemDecoration(
            DividerItemDecoration(
                mViewBinding.recyclerClinics.context,
                (mViewBinding.recyclerClinics.layoutManager as LinearLayoutManager).orientation
            )
        )
        mViewBinding.recyclerClinics.adapter = adapter
    }

    private fun subscribeObservers() {
        mViewModel.clinics.observe(viewLifecycleOwner, { clinicsList: List<Clinic> ->
            populateRecyclerView(clinicsList)
        })
    }

    private fun populateRecyclerView(clinicsList: List<Clinic>) {
        if (!clinicsList.isNullOrEmpty()) adapter.setItems(clinicsList)
    }
}