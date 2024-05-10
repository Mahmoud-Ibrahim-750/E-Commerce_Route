package com.mis.route.e_commerce.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<State, Event> : ViewModel() {

    val state = MutableLiveData<State>()

    abstract fun invoke(event: Event)
}