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
import com.example.e4clinic.models.Client
import com.example.e4clinic.ui.adapters.AttachementFilesAdapter
import com.example.e4clinic.ui.adapters.ClientsAdapter
import com.example.e4clinic.ui.core.BaseFragment
import com.example.e4clinic.ui.viewmodel.AddFeedbackViewModel
import com.example.e4clinic.ui.viewmodel.ClinicsDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddFeedbackFragment :
    BaseFragment<AddFeedbackViewModel, FragmentAddFeedbackBinding>() {
    private lateinit var adapter: AttachementFilesAdapter
    val args: AddFeedbackFragmentArgs by navArgs()
    private val mViewModel: AddFeedbackViewModel by viewModels()
    private lateinit var mViewBinding: FragmentAddFeedbackBinding

    override fun getLayoutId(): Int =
        R.layout.fragment_add_feedback

    override fun getBindingVariable(): Int = BR.viewModel

    override fun getViewModel(): AddFeedbackViewModel = mViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewBinding = getViewDataBinding()
        val clinic = args.clinicArgument
        clinic?.let {
            mViewBinding.txtDoctorName.text = it.doctorName
            mViewBinding.txtTime.text = it.visitTime
            mViewBinding.txtLocation.text = it.address
        }
        setupRecyclerView()
    }
    private fun setupRecyclerView() {
        mViewBinding.recyclerAttachements.layoutManager = LinearLayoutManager(requireActivity() ,LinearLayoutManager.HORIZONTAL, false)
        adapter = AttachementFilesAdapter()
        mViewBinding.recyclerAttachements.addItemDecoration(
            DividerItemDecoration(
                mViewBinding.recyclerAttachements.context,
                (mViewBinding.recyclerAttachements.layoutManager as LinearLayoutManager).orientation
            )
        )
        mViewBinding.recyclerAttachements.adapter = adapter
    }



}