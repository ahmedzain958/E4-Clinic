package com.example.e4_clinic.ui.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.e4_clinic.R
import com.example.e4_clinic.ui.core.BaseViewModel
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.toolbar_layout.view.*


class HomeActivity : AppCompatActivity() {
    var count = 0
    var textInboxItemCount: TextView? = null
    var textNotificationItemCount: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        navHostFragment.findNavController()//to determine the only bottom nav drawer fragments
            .addOnDestinationChangedListener { controller, destination, arguments ->
                when (destination.id) {
                    R.id.homeFragment -> { toolbar.visibility = View.VISIBLE
                        toolbar.tvToolbarTitle.text = getString(R.string.home)
                        bottomNavigationView.visibility = View.VISIBLE
                    }
                    R.id.clientFragment -> {
                        toolbar.visibility = View.VISIBLE
                        toolbar.tvToolbarTitle.text = getString(R.string.client)
                        bottomNavigationView.visibility = View.VISIBLE
                    }
                    R.id.blogFragment -> {
                        toolbar.visibility = View.VISIBLE
                        toolbar.tvToolbarTitle.text = getString(R.string.blog)
                        bottomNavigationView.visibility = View.VISIBLE
                    }
                    R.id.moreFragment -> {
                        toolbar.visibility = View.VISIBLE
                        toolbar.tvToolbarTitle.text = getString(R.string.more)
                        bottomNavigationView.visibility = View.VISIBLE
                    }
                    else -> {
                        toolbar.visibility = View.GONE
                        bottomNavigationView.visibility = View.GONE
                    }
                }
            }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        val menuItemInbox: MenuItem = menu!!.findItem(R.id.action_inbox)
//        val menuItemNotification: MenuItem = menu.findItem(R.id.action_notification)

        val actionViewInbox: View = menuItemInbox.actionView
//        val actionViewNotification: View = menuItemNotification.actionView
        textInboxItemCount = actionViewInbox.findViewById<View>(R.id.txt_badge) as TextView
//        textNotificationItemCount =
//            actionViewNotification.findViewById<View>(R.id.txt_badge) as TextView
        setupBadge()
        actionViewInbox.setOnClickListener { onOptionsItemSelected(menuItemInbox) }
//        actionViewNotification.setOnClickListener { onOptionsItemSelected(menuItemNotification) }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_inbox -> {
                Toast.makeText(this, "Inbox clicked", Toast.LENGTH_SHORT).show()
                return true
            }
//            R.id.action_notification -> {
//                Toast.makeText(this, "Notification clicked", Toast.LENGTH_SHORT).show()
//                return true
//            }
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