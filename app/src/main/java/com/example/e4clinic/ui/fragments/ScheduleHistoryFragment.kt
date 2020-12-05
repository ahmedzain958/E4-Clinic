package com.example.e4clinic.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e4clinic.BR
import com.example.e4clinic.R
import com.example.e4clinic.databinding.FragmentMoreBinding
import com.example.e4clinic.databinding.FragmentScheduleHistoryBinding
import com.example.e4clinic.models.Client
import com.example.e4clinic.other.E4ClinicUtility
import com.example.e4clinic.ui.adapters.ClientsAdapter
import com.example.e4clinic.ui.adapters.ClinicsAdapter
import com.example.e4clinic.ui.adapters.ScheduleHistoryAdapter
import com.example.e4clinic.ui.core.BaseFragment
import com.example.e4clinic.ui.viewmodel.MoreViewModel
import com.example.e4clinic.ui.viewmodel.ScheduleHistoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ScheduleHistoryFragment : BaseFragment<ScheduleHistoryViewModel, FragmentScheduleHistoryBinding>(),
    ScheduleHistoryAdapter.FeedbackSummaryOnClickListener {
    private lateinit var mViewBinding: FragmentScheduleHistoryBinding
    override fun getBindingVariable(): Int = BR.viewModel
    private val mViewModel: ScheduleHistoryViewModel by viewModels()
    override fun getViewModel(): ScheduleHistoryViewModel = mViewModel
    override fun getLayoutId(): Int =
        R.layout.fragment_schedule_history
    private lateinit var adapter: ScheduleHistoryAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewBinding = getViewDataBinding()
        setupRecyclerView()
        subscribeObservers()
        mViewModel.getHistory()
        mViewBinding.txtMonthYear.text = E4ClinicUtility.getCurrentMonthYear()
    }
    private fun subscribeObservers() {
        mViewModel.history.observe(viewLifecycleOwner, { history: List<Any> ->
            populateRecyclerView(history)
        })
    }
    private fun populateRecyclerView(history: List<Any>) {
        if (!history.isNullOrEmpty()) adapter.setItems(history)
    }
    private fun setupRecyclerView() {
        mViewBinding.recyclerHistory.layoutManager = LinearLayoutManager(requireActivity())
        adapter = ScheduleHistoryAdapter(this)
        mViewBinding.recyclerHistory.addItemDecoration(
            DividerItemDecoration(
                mViewBinding.recyclerHistory.context,
                (mViewBinding.recyclerHistory.layoutManager as LinearLayoutManager).orientation
            )
        )
        mViewBinding.recyclerHistory.adapter = adapter
    }

    override fun onClickedFeedback(any: Any) {
        TODO("Not yet implemented")
    }
}