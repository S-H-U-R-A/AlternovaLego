package com.alternova.lego

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.alternova.lego.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        //START SPLASH SCREEN
        val splashScreen: SplashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition{ false }
        //INFLATE ACTIVITY
        super.onCreate(savedInstanceState)
        //SET LAYOUT
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //INIT COMPONENTS
        initComponents()
    }

    private fun initComponents() {
        //SET TOOLBAR
        setSupportActionBar(binding.toolbar)
        //BOTTOM NAVIGATION
        val bottomNavigationView: BottomNavigationView = binding.bottomNavigation
        //GET AND SET NAV-CONTROLLER
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        //SET TOOLBAR/ACTIONBAR OF NAVIGATION WITH NAV-CONTROLLER
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.productsFragment,
                R.id.shoppingCarFragment
            )
        )
        setupActionBarWithNavController( navController, appBarConfiguration)
        //SETUP BOTTOM NAVIGATION WITH NAVCONTROLLER
        bottomNavigationView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}