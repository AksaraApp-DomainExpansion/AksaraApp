package com.example.aksaraapp.ui.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHost
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.aksaraapp.R
import com.example.aksaraapp.databinding.ActivityMainNavigationBinding
import kotlinx.coroutines.launch

class MainNavigationActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainNavigationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHost = supportFragmentManager.findFragmentById(binding.navHost.id) as NavHostFragment

        val inflater = navHost.navController.navInflater
        val graph = inflater.inflate(R.navigation.aksara_navigation)

        graph.setStartDestination(R.id.navigation_home)
        navHost.navController.graph = graph

        binding.navView.setupWithNavController(navHost.navController)

        binding.navView.setOnItemSelectedListener {
            navHost.navController.navigate(it.itemId)
            return@setOnItemSelectedListener true
        }

        navHost.navController.addOnDestinationChangedListener{
            _, destination, _ ->
            Handler(Looper.getMainLooper()).post{
                binding.navView.visibility = when(destination.id){
                    R.id.navigation_home -> View.VISIBLE
                    R.id.navigation_translate -> View.VISIBLE
                    R.id.navigation_course -> View.VISIBLE
                    R.id.navigation_cart -> View.VISIBLE
                    R.id.navigation_message -> View.VISIBLE
                    else -> View.GONE
                }
            }
        }

        onBackPressedDispatcher.addCallback(this, object :OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                val currentFragment = navHost.navController.currentDestination
                lifecycleScope.launch {
                    if(currentFragment?.id == R.id.navigation_home){
                        finish()
                    }else{
                        navHost.navController.navigateUp()
                    }
                }
            }
        })
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host)
        val navigateUp = navController.navigateUp()
        return navigateUp || super.onSupportNavigateUp()
    }
}