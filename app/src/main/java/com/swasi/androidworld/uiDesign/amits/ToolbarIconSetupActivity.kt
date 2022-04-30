package com.swasi.androidworld.uiDesign.amits

import android.os.Bundle
import android.view.Menu
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.swasi.androidworld.R
import com.swasi.androidworld.databinding.ActivityToolbarIconSetupBinding

class ToolbarIconSetupActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityToolbarIconSetupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityToolbarIconSetupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarToolbarIconSetup.toolbar)

        binding.appBarToolbarIconSetup.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_toolbar_icon_setup)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        binding.appBarToolbarIconSetup.toolbar.navigationIcon = ContextCompat.getDrawable(this,R.drawable.ic_baseline_chevron_left_24)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.toolbar_icon_setup, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_toolbar_icon_setup)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    public fun setUpNavigationIcon(){
        binding.appBarToolbarIconSetup.toolbar.navigationIcon = ContextCompat.getDrawable(this,R.drawable.ic_baseline_chevron_left_24)
    }

}