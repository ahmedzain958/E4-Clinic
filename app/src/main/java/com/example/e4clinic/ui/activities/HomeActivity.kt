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
    var count = 0
    var textInboxItemCount: TextView? = null

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
                    }
                    R.id.clientFragment -> {
                        setToolbarVisibility()
                        tvToolbarTitle.text = getString(R.string.client)
                    }
                    R.id.blogFragment -> {
                        setToolbarVisibility()
                        tvToolbarTitle.text = getString(R.string.blog)
                    }
                    R.id.moreFragment -> {
                        setToolbarVisibility()
                        tvToolbarTitle.text = getString(R.string.more)
                    }
                    R.id.loginFragment -> {
                        toolbar.menu.clear()
                        toolbar.visibility = View.GONE
                        bottomNavigationView.visibility = View.GONE
                    }
                    R.id.addClientFragment -> {
                        setToolbarVisibility(false, false)
                        tvToolbarTitle.text = getString(R.string.add_new_client)
                        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
                        toolbar.setNavigationOnClickListener {
                            onBackPressed()
                        }
                    }
                    else -> {
                        setToolbarVisibility(false, false)
                        tvToolbarTitle.text = getString(R.string.schedule)
                        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
                        toolbar.setNavigationOnClickListener {
                            onBackPressed()
                        }
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

    private fun setToolbarVisibility(
        inflateMenu: Boolean = true,
        displayBottomNav: Boolean = true
    ) {
        toolbar.visibility = View.VISIBLE
        toolbar.menu.clear()
        supportActionBar?.setDisplayHomeAsUpEnabled(!displayBottomNav)
        supportActionBar?.setDisplayShowHomeEnabled(!displayBottomNav)
        if (displayBottomNav) {
            bottomNavigationView.visibility =
                View.VISIBLE
            img_icon.visibility = View.VISIBLE
        } else {
            bottomNavigationView.visibility = View.GONE
            img_icon.visibility = View.GONE
        }
        if (inflateMenu) toolbar.inflateMenu(R.menu.toolbar_menu)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        val menuItemInbox: MenuItem = menu!!.findItem(R.id.action_inbox)
        val menuItemNotification: MenuItem = menu.findItem(R.id.action_notification)

        val actionViewInbox: View = menuItemInbox.actionView
        val actionViewNotification: View = menuItemNotification.actionView
        textInboxItemCount = actionViewInbox.findViewById<View>(R.id.txt_badge) as TextView
        val textNotificationItemCount =
            actionViewNotification.findViewById<View>(R.id.txt_badge) as TextView
        setupBadge()
        actionViewInbox.setOnClickListener { onOptionsItemSelected(menuItemInbox) }
        actionViewNotification.setOnClickListener { onOptionsItemSelected(menuItemNotification) }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_inbox -> {
                Toast.makeText(this, "Inbox clicked", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_notification -> {
                Toast.makeText(this, "Notification clicked", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    private fun setupBadge() {
        textInboxItemCount?.let {
            if (count >= 0) {
                it.visibility = View.VISIBLE;
                it.text = count.inc().toString();
            } else {
                it.visibility = View.GONE;
            }
        }

    }
}