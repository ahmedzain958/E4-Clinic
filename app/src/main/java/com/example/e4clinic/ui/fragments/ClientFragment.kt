package com.example.e4clinic.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e4clinic.BR
import com.example.e4clinic.R
import com.example.e4clinic.databinding.FragmentClientBinding
import com.example.e4clinic.databinding.FragmentHomeBinding
import com.example.e4clinic.databinding.FragmentPharmaciesBinding
import com.example.e4clinic.models.Client
import com.example.e4clinic.models.Pharmacy
import com.example.e4clinic.other.E4ClinicUtility
import com.example.e4clinic.ui.adapters.ClientsAdapter
import com.example.e4clinic.ui.adapters.PharmaciesAdapter
import com.example.e4clinic.ui.core.BaseFragment
import com.example.e4clinic.ui.viewmodel.CientViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ClientFragment : BaseFragment<CientViewModel, FragmentClientBinding>() {
    private val mViewModel: CientViewModel by viewModels()

    override fun getLayoutId() = R.layout.fragment_client

    override fun getBindingVariable() = BR.viewModel

    override fun getViewModel() = mViewModel
    private lateinit var mViewBinding: FragmentClientBinding

    private lateinit var adapter: ClientsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewBinding = getViewDataBinding()
        setupRecyclerView()
        subscribeObservers()
        mViewModel.getClients()
    }


    private fun setupRecyclerView() {
        adapter = ClientsAdapter()
        mViewBinding.clientsRecyclerView.addItemDecoration(
            DividerItemDecoration(
                mViewBinding.clientsRecyclerView.context,
                (mViewBinding.clientsRecyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        mViewBinding.clientsRecyclerView.adapter = adapter
    }

    private fun subscribeObservers() {
        mViewModel.clients.observe(viewLifecycleOwner, { pharmaciesList: List<Client> ->
            populateRecyclerView(pharmaciesList)
        })
    }

    private fun populateRecyclerView(clientsList: List<Client>) {
        if (!clientsList.isNullOrEmpty()) adapter.setItems(clientsList)
    }


}