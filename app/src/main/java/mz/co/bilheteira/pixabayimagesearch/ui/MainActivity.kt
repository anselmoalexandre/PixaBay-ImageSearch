package mz.co.bilheteira.pixabayimagesearch.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import dagger.hilt.android.AndroidEntryPoint
import mz.co.bilheteira.pixabayimagesearch.R

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val defaultHostFragment by lazy { supportFragmentManager.findFragmentById(R.id.nav_host_fragment) }
    private val navController by lazy { (defaultHostFragment as NavHostFragment).navController }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return NavigationUI.navigateUp(navController, AppBarConfiguration(navController.graph))
    }
}