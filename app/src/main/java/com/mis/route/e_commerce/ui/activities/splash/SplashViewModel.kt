package com.mis.route.e_commerce.ui.activities.splash

import android.os.Handler
import android.os.Looper
import com.mis.route.e_commerce.ui.activities.splash.contracts.SplashEvent
import com.mis.route.e_commerce.ui.activities.splash.contracts.SplashState
import com.mis.route.e_commerce.ui.base.BaseViewModel

const val SPLASH_DELAY_INTERVAL: Long = 2000 // milliseconds

class SplashViewModel : BaseViewModel<SplashState, SplashEvent>() {

    init {
        Handler(Looper.getMainLooper()).postDelayed({
            state.value = SplashState.NavigateToHome
        }, SPLASH_DELAY_INTERVAL)
    }

    override fun invoke(event: SplashEvent) {

    }
}