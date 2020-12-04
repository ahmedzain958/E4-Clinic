package com.example.e4clinic.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.e4clinic.BR
import com.example.e4clinic.R
import com.example.e4clinic.databinding.FragmentClinicsDetailsBinding
import com.example.e4clinic.ui.core.BaseFragment
import com.example.e4clinic.ui.viewmodel.ClinicsDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ClinicsDetailsFragment :
    BaseFragment<ClinicsDetailsViewModel, FragmentClinicsDetailsBinding>() {
    val args: ClinicsDetailsFragmentArgs by navArgs()
    private val mViewModel: ClinicsDetailsViewModel by viewModels()
    private lateinit var mViewBinding: FragmentClinicsDetailsBinding

    override fun getLayoutId(): Int =
        R.layout.fragment_clinics_details

    override fun getBindingVariable(): Int = BR.viewModel

    override fun getViewModel(): ClinicsDetailsViewModel = mViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewBinding = getViewDataBinding()
        val clinic = args.clinicArgument
        clinic?.let {
            mViewBinding.txtDoctorName.text = it.doctorName
            mViewBinding.txtTime.text = it.visitTime
            mViewBinding.txtLocation.text = it.address
            mViewBinding.txtStatus.text = it.status
        }

    }



}