package com.mis.route.e_commerce.presentation.ui.activities.auth

import android.os.Bundle
import com.mis.route.e_commerce.R
import com.mis.route.e_commerce.databinding.ActivityAuthBinding
import com.mis.route.e_commerce.presentation.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthActivity : BaseActivity<ActivityAuthBinding>() {
    override fun getLayoutId(): Int = R.layout.activity_auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}