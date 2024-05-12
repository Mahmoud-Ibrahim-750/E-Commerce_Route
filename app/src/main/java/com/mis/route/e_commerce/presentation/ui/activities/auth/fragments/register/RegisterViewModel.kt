package com.mis.route.e_commerce.presentation.ui.activities.auth.fragments.register

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.mis.route.e_commerce.data.data_sources.local.shared_preferences.SharedPreferencesHelper
import com.mis.route.e_commerce.domain.usecases.auth.RegisterUseCase
import com.mis.route.e_commerce.presentation.ui.activities.auth.fragments.register.contracts.RegisterScreenEvent
import com.mis.route.e_commerce.presentation.ui.activities.auth.fragments.register.contracts.RegisterScreenState
import com.mis.route.e_commerce.presentation.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

const val TAG = "RegisterViewModel"

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase,
    private val sharedPreferencesHelper: SharedPreferencesHelper
) : BaseViewModel<RegisterScreenState, RegisterScreenEvent>() {


    override fun invoke(event: RegisterScreenEvent) {
        when (event) {
            is RegisterScreenEvent.Register -> register(event)
        }
    }

    private fun register(registerEvent: RegisterScreenEvent.Register) {
        viewModelScope.launch(Dispatchers.IO) {
            if (!isUserInputValid()) return@launch

            try {
                val registerResponse = with(registerEvent) {
                    registerUseCase(name, email, password, rePassword, phone)
                }
                with(registerResponse) {
                    if (user == null || token == null) Log.e(TAG, "register: null user & token")
                    else {
                        sharedPreferencesHelper.saveUserToken(token)
                        state.postValue(RegisterScreenState.NavigateToHome(user, token))
                    }
                }
            } catch (e: Exception) {
                Log.e(TAG, "register: ${e.message}")
            }
        }
    }

    private fun isUserInputValid(): Boolean {
        // TODO: a regex may be used in validation, use one later
//        val inputErrors = LoginScreenState.InvalidUserInput()
        return true
    }
}
