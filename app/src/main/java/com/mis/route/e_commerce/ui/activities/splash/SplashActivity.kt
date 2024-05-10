package com.mis.route.e_commerce.ui.activities.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.mis.route.e_commerce.R
import com.mis.route.e_commerce.databinding.ActivitySplashBinding
import com.mis.route.e_commerce.ui.activities.home.HomeActivity
import com.mis.route.e_commerce.ui.activities.splash.contracts.SplashState
import com.mis.route.e_commerce.ui.base.BaseActivity

@SuppressLint("CustomSplashScreen") // TODO: from Android 12 up, use the Splash Screen API
class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_splash

    private lateinit var viewModel: SplashViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[SplashViewModel::class.java]
        viewModel.state.observe(this, ::renderUiState)
    }

    private fun renderUiState(state: SplashState) {
        when (state) {
            SplashState.NavigateToHome -> navigateToHomeScreen()
        }
    }

    private fun navigateToHomeScreen() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}
