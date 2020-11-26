package com.example.e4_clinic.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.e4_clinic.R
import com.example.e4_clinic.ui.core.BaseActivity
import com.example.e4_clinic.ui.core.BaseViewModel
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity<BaseViewModel, ViewDataBinding>(BaseViewModel::class.java) {
    override fun getLayoutRes(): Int = R.layout.activity_home
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bottomNavigationView.setupWithNavController(navHostFragment.findNavController())
        navHostFragment.findNavController()//to determine the only bottom nav drawer fragments
            .addOnDestinationChangedListener { controller, destination, arguments ->
                when (destination.id) {
                    R.id.homeFragment, R.id.clientFragment, R.id.blogFragment, R.id.moreFragment ->
                        bottomNavigationView.visibility = View.VISIBLE
                    else -> bottomNavigationView.visibility = View.GONE
                }
            }
    }

    override fun initViewModel(viewModel: BaseViewModel) {
        TODO("Not yet implemented")
    }
}