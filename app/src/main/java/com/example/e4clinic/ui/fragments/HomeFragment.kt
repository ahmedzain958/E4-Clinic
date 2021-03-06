package com.example.e4clinic.ui.fragments

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.BitmapDrawable
import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.os.Bundle
import android.provider.ContactsContract
import android.util.DisplayMetrics
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.e4clinic.R
import com.example.e4clinic.databinding.FragmentHomeBinding
import com.example.e4clinic.other.E4ClinicUtility.getCurrentMonthYear
import com.example.e4clinic.ui.core.BaseFragment
import com.example.e4clinic.BR
import com.example.e4clinic.ui.viewmodel.HomeViewModel
import com.squareup.picasso.Picasso
import org.joda.time.DateTime


class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {
    private lateinit var mBinding: FragmentHomeBinding
    override fun getBindingVariable(): Int = BR.viewModel
    override fun getLayoutId(): Int =
        R.layout.fragment_home

    private val mViewModel: HomeViewModel by viewModels()
    override fun getViewModel(): HomeViewModel = mViewModel


    private fun initListeners() {
        mBinding.calenderWeek.setOnDateClickListener { dateTime: DateTime ->
            mBinding.txtMonthYear.text = getCurrentMonthYear(dateTime)
        }
        mBinding.cardviewClinics.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_clinicsFragment)
        }
        mBinding.cardviewPharmacies.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_pharmaciesFragment)
        }
        mBinding.cardviewVideoCalls.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_videoCallsFragment)
        }

      /*  mBinding.progressChart.progressColor =
            ContextCompat.getColor(requireActivity(), R.color.purple_200)*/
       /* mBinding.progressChart.secondaryProgressColors = intArrayOf(R.color.purple_200,R.color.colorLightMove,R.color.colorLightGreen)

        mBinding.progressChart.secondaryProgressColor =
            ContextCompat.getColor(requireActivity(), R.color.colorLightGreen)
        mBinding.progressChart.max = 40f
        mBinding.progressChart.progress = 10f
        mBinding.progressChart.secondaryProgress = 20f*/
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding = getViewDataBinding()
        initListeners()
        mBinding.txtMonthYear.text = getCurrentMonthYear()
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