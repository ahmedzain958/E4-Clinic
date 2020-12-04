package com.example.e4clinic.ui.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.e4clinic.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_home.*


@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        navHostFragment.findNavController()//to determine the only bottom nav drawer fragments
            .addOnDestinationChangedListener { controller, destination, arguments ->
                when (destination.id) {
                    R.id.homeFragment -> {
                        setToolbarVisibility()
                        tvToolbarTitle.text = getString(R.string.home)
                        group_notification.visibility = View.VISIBLE
                    }
                    R.id.clientFragment -> {
                        setToolbarVisibility()
                        tvToolbarTitle.text = getString(R.string.client)
                        group_notification.visibility = View.VISIBLE
                    }
                    R.id.blogFragment -> {
                        setToolbarVisibility()
                        tvToolbarTitle.text = getString(R.string.blog)
                        group_notification.visibility = View.VISIBLE
                    }
                    R.id.moreFragment -> {
                        setToolbarVisibility()
                        tvToolbarTitle.text = getString(R.string.more)
                        group_notification.visibility = View.VISIBLE
                    }
                    R.id.loginFragment -> {
                        toolbar.menu.clear()
                        toolbar.visibility = View.GONE
                        bottomNavigationView.visibility = View.GONE
                    }
                    R.id.clinicsFragment, R.id.pharmaciesFragment, R.id.videoCallsFragment -> {
                        setupSubViews(toolbar)
                    }
                    else -> {
                        setToolbarVisibility(false)
                        tvToolbarTitle.text = getString(R.string.schedule)
                        toolbar.setOnClickListener {
                            onBackPressed()
                        }
                        group_notification.visibility = View.INVISIBLE
                    }
                }
            }
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.navHostFragment) as NavHostFragment?
        NavigationUI.setupWithNavController(
            bottomNavigationView,
            navHostFragment!!.navController
        )
    }

    private fun setupSubViews(toolbar: Toolbar) {
        setToolbarVisibility(false, false)
        tvToolbarTitle.text = getString(R.string.schedule)
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun setToolbarVisibility(
        displayBottomNav: Boolean = true
    ) {
        toolbar.visibility = View.VISIBLE
        if (displayBottomNav) {
            bottomNavigationView.visibility =
                View.VISIBLE
            img_icon.visibility = View.VISIBLE
            img_back.visibility = View.INVISIBLE
        } else {
            bottomNavigationView.visibility = View.GONE
            img_icon.visibility = View.INVISIBLE
            img_back.visibility = View.VISIBLE
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}