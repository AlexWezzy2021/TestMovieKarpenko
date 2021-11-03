package co.tiim.testkarpenkoalex.presentatation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import co.tiim.testkarpenkoalex.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_home_host_fragment) as NavHostFragment?
        val navController = navHostFragment!!.navController
        NavigationUI.setupWithNavController(bottomNavigation, navController)

    }


}