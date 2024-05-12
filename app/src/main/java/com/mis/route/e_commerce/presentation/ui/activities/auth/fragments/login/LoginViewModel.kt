package com.mis.route.e_commerce.presentation.ui.activities.auth.fragments.login

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.mis.route.e_commerce.data.data_sources.local.shared_preferences.SharedPreferencesHelper
import com.mis.route.e_commerce.domain.usecases.auth.LoginUseCase
import com.mis.route.e_commerce.presentation.ui.activities.auth.fragments.login.contracts.LoginScreenEvent
import com.mis.route.e_commerce.presentation.ui.activities.auth.fragments.login.contracts.LoginScreenState
import com.mis.route.e_commerce.presentation.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

const val TAG = "LoginViewModel"

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val sharedPreferencesHelper: SharedPreferencesHelper
) : BaseViewModel<LoginScreenState, LoginScreenEvent>() {


    override fun invoke(event: LoginScreenEvent) {
        when (event) {
            is LoginScreenEvent.Login -> login(event.email, event.password)
        }
    }

    private fun login(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            if (!isUserInputValid()) return@launch

            try {
                val loginResponse = loginUseCase(email, password)
                with(loginResponse) {
                    if (user == null || token == null) Log.d(TAG, "login: null user & token")
                    else {
                        sharedPreferencesHelper.saveUserToken(loginResponse.token)
                        state.value = LoginScreenState
                            .NavigateToHome(loginResponse.user!!, loginResponse.token!!)
                    }
                }
            } catch (e: Exception) {
                Log.d(TAG, "login: ${e.message}")
            }
        }
    }

    private fun isUserInputValid(): Boolean {
        // TODO: a regex may be used in validation, use one later
//        val inputErrors = LoginScreenState.InvalidUserInput()
        return true
    }
}
