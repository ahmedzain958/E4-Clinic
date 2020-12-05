package com.example.e4clinic.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e4clinic.BR
import com.example.e4clinic.R
import com.example.e4clinic.databinding.FragmentAddFeedbackBinding
import com.example.e4clinic.databinding.FragmentClinicsDetailsBinding
import com.example.e4clinic.databinding.FragmentFeedbackSummaryBinding
import com.example.e4clinic.models.Client
import com.example.e4clinic.models.Clinic
import com.example.e4clinic.models.Pharmacy
import com.example.e4clinic.ui.adapters.AttachementFilesAdapter
import com.example.e4clinic.ui.adapters.ClientsAdapter
import com.example.e4clinic.ui.adapters.FeedbackSummaryAdapter
import com.example.e4clinic.ui.core.BaseFragment
import com.example.e4clinic.ui.viewmodel.AddFeedbackViewModel
import com.example.e4clinic.ui.viewmodel.ClinicsDetailsViewModel
import com.example.e4clinic.ui.viewmodel.FeedbackSummaryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeedbackSummaryFragment :
    BaseFragment<FeedbackSummaryViewModel, FragmentFeedbackSummaryBinding>() {
    private lateinit var adapter: FeedbackSummaryAdapter
    val args: FeedbackSummaryFragmentArgs by navArgs()
    private val mViewModel: FeedbackSummaryViewModel by viewModels()
    private lateinit var mViewBinding: FragmentFeedbackSummaryBinding

    override fun getLayoutId(): Int =
        R.layout.fragment_feedback_summary

    override fun getBindingVariable(): Int = BR.viewModel

    override fun getViewModel(): FeedbackSummaryViewModel = mViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewBinding = getViewDataBinding()
        val clinic = args.clinicArgument
        val pharmacy = args.pharmacyArgument
        clinic?.let {
            mViewBinding.txtDoctorName.text = clinic.doctorName
            mViewBinding.txtTime.text = clinic.visitTime
            mViewBinding.txtLocation.text = clinic.address
        }
        pharmacy?.let {
            mViewBinding.txtDoctor.visibility = View.GONE
            mViewBinding.txtDoctorName.text = pharmacy.pharmacyName
            mViewBinding.txtTime.text = pharmacy.visitTime
            mViewBinding.txtLocation.text = pharmacy.address
        }
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        mViewBinding.recyclerAttachements.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        adapter = FeedbackSummaryAdapter()
        mViewBinding.recyclerAttachements.addItemDecoration(
            DividerItemDecoration(
                mViewBinding.recyclerAttachements.context,
                (mViewBinding.recyclerAttachements.layoutManager as LinearLayoutManager).orientation
            )
        )
        mViewBinding.recyclerAttachements.adapter = adapter
    }


}