package com.example.hw_2

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.hw_2.databinding.ActivityFragmentMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFragmentActivity : AppCompatActivity() {

    private var binding: ActivityFragmentMainBinding? = null
    private var controller: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        controller = (supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment)
            .navController

        controller?.let { navController ->
            binding?.bottomNavigation?.setupWithNavController(navController)
            navController.addOnDestinationChangedListener {_, destination, _ ->
                handleBottomNavigationViewvisibility(destination)
            }
        }
    }

    private fun handleBottomNavigationViewvisibility(destination: NavDestination){
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        val showBottomNav = when (destination.id) {
            R.id.additionalFragment,
            R.id.birdProfileFragment -> false
            else -> true
        }

        bottomNavigationView.visibility = if (showBottomNav) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}