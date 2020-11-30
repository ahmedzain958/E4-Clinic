package com.example.e4clinic.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e4clinic.ui.viewmodel.VideoCallsViewModel
import com.example.e4clinic.BR
import com.example.e4clinic.R
import com.example.e4clinic.databinding.FragmentVideocallsBinding
import com.example.e4clinic.models.VideoCall
import com.example.e4clinic.other.E4ClinicUtility
import com.example.e4clinic.ui.adapters.VideoCallsAdapter
import com.example.e4clinic.ui.core.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideoCallsFragment :
    BaseFragment<VideoCallsViewModel, FragmentVideocallsBinding>() {
    private lateinit var adapter: VideoCallsAdapter
    private val mViewModel: VideoCallsViewModel by viewModels()
    override fun getViewModel(): VideoCallsViewModel = mViewModel
    private lateinit var mViewBinding: FragmentVideocallsBinding
    override fun getBindingVariable(): Int = BR.viewModel
    override fun getLayoutId(): Int =
        R.layout.fragment_videocalls

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewBinding = getViewDataBinding()
        setupRecyclerView()
        subscribeObservers()
        initListeners()
        mViewModel.getVideoCalls()
        mViewBinding.txtMonthYear.text = E4ClinicUtility.getCurrentMonthYear()
    }

    private fun initListeners() {
        /* mViewBinding.calenderWeek.setOnDateClickListener { dateTime: DateTime ->
             mViewBinding.txtMonthYear.text = E4ClinicUtility.getCurrentMonthYear(dateTime)
         }*/
    }


    private fun setupRecyclerView() {
        mViewBinding.recyclerVideocalls.layoutManager = LinearLayoutManager(requireActivity())
        adapter = VideoCallsAdapter()
        mViewBinding.recyclerVideocalls.addItemDecoration(
            DividerItemDecoration(
                mViewBinding.recyclerVideocalls.context,
                (mViewBinding.recyclerVideocalls.layoutManager as LinearLayoutManager).orientation
            )
        )
        mViewBinding.recyclerVideocalls.adapter = adapter
    }

    private fun subscribeObservers() {
        mViewModel.VideoCalls.observe(viewLifecycleOwner, { videoCallsList: List<VideoCall> ->
            populateRecyclerView(videoCallsList)
        })
    }

    private fun populateRecyclerView(VideoCallsList: List<VideoCall>) {
        if (!VideoCallsList.isNullOrEmpty()) adapter.setItems(VideoCallsList)
    }
}