package com.example.e4clinic.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.e4clinic.R
import com.example.e4clinic.databinding.FragmentClinicsBinding
import com.example.e4clinic.databinding.FragmentHomeBinding
import com.example.e4clinic.other.E4ClinicUtility
import com.example.e4clinic.ui.core.BaseFragment
import com.example.e4clinic.ui.core.BaseViewModel
import org.joda.time.DateTime

class ClinicsFragment : BaseFragment<BaseViewModel, FragmentClinicsBinding>(BaseViewModel::class.java) {
    override fun getLayoutRes(): Int = R.layout.fragment_clinics
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = super.onCreateView(inflater, container, savedInstanceState)
        initListeners()
        return view
    }
    private fun initListeners() {
        mBinding.calenderWeek.setOnDateClickListener { dateTime: DateTime ->
            mBinding.txtMonthYear.text = E4ClinicUtility.getCurrentMonthYear(dateTime)
        }

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mBinding.txtMonthYear.text = E4ClinicUtility.getCurrentMonthYear()
        super.onViewCreated(view, savedInstanceState)
    }

}