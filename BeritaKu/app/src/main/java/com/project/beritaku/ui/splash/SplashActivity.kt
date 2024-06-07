package com.project.beritaku.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.project.beritaku.databinding.ActivitySplashBinding
import com.project.beritaku.ui.main.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private val splashViewModel by viewModel<SplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observeViewModel()
        handleSplash()
    }

    private fun observeViewModel() {
        splashViewModel.getDarkMode().observe(this) {
            if (it)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            else
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    private fun handleSplash() {
        Handler(Looper.getMainLooper()).apply {
            postDelayed({
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            }, 1500L)
        }
    }
}