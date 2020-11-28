package com.example.e4clinic.ui.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.e4clinic.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.toolbar_layout.*
import kotlinx.android.synthetic.main.toolbar_layout.view.tvToolbarTitle


@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    var count = 0
    var textInboxItemCount: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        navHostFragment.findNavController()//to determine the only bottom nav drawer fragments
            .addOnDestinationChangedListener { controller, destination, arguments ->
                when (destination.id) {
                    R.id.homeFragment -> {
                        toolbar.menu.clear()
                        toolbar.visibility = View.VISIBLE
                        toolbar.tvToolbarTitle.text = getString(R.string.home)
                        bottomNavigationView.visibility = View.VISIBLE
                        toolbar.inflateMenu(R.menu.toolbar_menu)
                    }
                    R.id.clientFragment -> {
                        toolbar.menu.clear()
                        toolbar.visibility = View.VISIBLE
                        toolbar.tvToolbarTitle.text = getString(R.string.client)
                        bottomNavigationView.visibility = View.VISIBLE
                        toolbar.inflateMenu(R.menu.toolbar_menu)
                    }
                    R.id.blogFragment -> {
                        toolbar.menu.clear()
                        toolbar.visibility = View.VISIBLE
                        toolbar.tvToolbarTitle.text = getString(R.string.blog)
                        bottomNavigationView.visibility = View.VISIBLE
                        toolbar.inflateMenu(R.menu.toolbar_menu)
                    }
                    R.id.moreFragment -> {
                        toolbar.menu.clear()
                        toolbar.visibility = View.VISIBLE
                        toolbar.tvToolbarTitle.text = getString(R.string.more)
                        bottomNavigationView.visibility = View.VISIBLE
                        toolbar.inflateMenu(R.menu.toolbar_menu)
                    }
                    else -> {
                        this.supportActionBar?.hide()
                        toolbar.menu.clear()
                        toolbar_layout.visibility = View.GONE
                        toolbar.visibility = View.GONE
                        bottomNavigationView.visibility = View.GONE
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
        }
        return super.onOptionsItemSelected(item)
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