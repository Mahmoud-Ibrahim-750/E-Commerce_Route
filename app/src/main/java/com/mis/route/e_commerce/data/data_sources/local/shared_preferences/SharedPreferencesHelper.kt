package com.mis.route.e_commerce.data.data_sources.local.shared_preferences

import android.content.SharedPreferences
import com.mis.route.e_commerce.data.DataConstants
import javax.inject.Inject

class SharedPreferencesHelper @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {
    fun saveUserToken(token: String?) {
        with(sharedPreferences.edit()) {
            putString(DataConstants.PREFS_USER_TOKEN_KEY, token)
            apply()
        }
    }

    fun getUserToken(): String? {
        with(sharedPreferences) {
            return getString(DataConstants.PREFS_USER_TOKEN_KEY, null)
        }
    }
}