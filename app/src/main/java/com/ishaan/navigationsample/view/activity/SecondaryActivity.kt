package com.ishaan.navigationsample.view.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.get
import androidx.navigation.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.ishaan.navigationsample.R
import kotlinx.android.synthetic.main.secondary_activity.*

class SecondaryActivity: AppCompatActivity() {

    private val args: SecondaryActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.secondary_activity)

        val navController = findNavController(R.id.secondary_nav_fragment)
        bottom_nav?.setupWithNavController(navController)

        setSupportActionBar(toolbar)
        setToolbarLabel(navController)
        //not used at the moment
        //val isWithPopup = args.withPopup

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setToolbarLabel(navController: NavController) {
        val title = navController.graph[R.id.secondary_fragment].label
        supportActionBar?.title = title
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            toolbar?.title = destination.label
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == android.R.id.home)
            findNavController(R.id.secondary_nav_fragment).navigateUp()
        return super.onOptionsItemSelected(item)
    }
}