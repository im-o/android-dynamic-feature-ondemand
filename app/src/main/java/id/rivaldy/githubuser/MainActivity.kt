package id.rivaldy.githubuser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import dagger.hilt.android.AndroidEntryPoint
import id.rivaldy.githubuser.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    override fun onSupportNavigateUp() = Navigation.findNavController(findViewById(R.id.mainNavHostFragment)).navigateUp()

    private fun initView() {
        setSupportActionBar(binding.toolbar)
        setupNavigation()
    }

    private fun setupNavigation() {
        val navController = Navigation.findNavController(findViewById(R.id.mainNavHostFragment))
        NavigationUI.setupActionBarWithNavController(this@MainActivity, navController)
    }
}