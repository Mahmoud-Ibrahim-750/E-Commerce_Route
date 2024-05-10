package com.mis.route.e_commerce.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {
    private var _binding: T? = null
    protected val binding: T get() = _binding!!


    abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.inflate(layoutInflater, getLayoutId(), null, false)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
