package com.example.e4clinic.ui.fragments

import android.os.Bundle
import android.view.*
import com.example.e4clinic.R
import com.example.e4clinic.databinding.FragmentHomeBinding
import com.example.e4clinic.other.E4ClinicUtility.getCurrentMonthYear
import com.example.e4clinic.ui.core.BaseFragment
import com.example.e4clinic.ui.core.BaseViewModel
import org.joda.time.DateTime


class HomeFragment : BaseFragment<BaseViewModel, FragmentHomeBinding>(BaseViewModel::class.java) {
    override fun getLayoutRes(): Int = R.layout.fragment_home

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
            mBinding.txtMonthYear.text = getCurrentMonthYear(dateTime)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
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