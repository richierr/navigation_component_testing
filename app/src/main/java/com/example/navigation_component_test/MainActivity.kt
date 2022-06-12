package com.example.navigation_component_test

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.navigation_component_test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var navHostFragment: NavHostFragment
    lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        setSupportActionBar(binding.toolbar)
        //val navController= Navigation.findNavController(this,R.id.nav_host_fragment_container)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navController = navHostFragment.navController
        setUpBottomNavMenu(navController)
        setUpActionBar(navController)
    }

    private fun setUpActionBar(navController: NavController) {
        NavigationUI.setupActionBarWithNavController(this,navController)
    }

    private fun setUpBottomNavMenu(navController: NavController){
        NavigationUI.setupWithNavController(binding.bottomNav,navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.title) {
            "Settings" -> NavigationUI.onNavDestinationSelected(item, navController)
            else -> false
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, AppBarConfiguration.Builder(navController.getGraph()).build())
    }
}