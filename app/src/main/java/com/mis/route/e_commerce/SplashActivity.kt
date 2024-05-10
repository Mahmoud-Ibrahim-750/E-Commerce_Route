package com.mis.route.e_commerce

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mis.route.e_commerce.databinding.ActivitySplashBinding
import com.mis.route.e_commerce.ui.activities.home.HomeActivity

@SuppressLint("CustomSplashScreen") // TODO: from Android 12 up, use the Splash Screen API
class SplashActivity : AppCompatActivity() {

    private var _binding: ActivitySplashBinding? = null
    private val binding: ActivitySplashBinding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigateToHomeScreen()
    }

    private fun navigateToHomeScreen() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}