package com.example.letssopt.data.local

import android.content.Context

class AuthRepository(context: Context) {
    private val pref = context.getSharedPreferences("LoginPref", Context.MODE_PRIVATE)

    fun isAutoLoginAvailable(): Boolean {
        val loginId = pref.getString("loginId", null)
        val password = pref.getString("password", null)
        return !loginId.isNullOrEmpty() && !password.isNullOrEmpty()
    }

    fun saveLogin(loginId: String, password: String) {
        pref.edit()
            .putString("loginId", loginId)
            .putString("password", password)
            .apply()
    }

    fun saveUserId(userId: Int) {
        pref.edit().putInt("userId", userId).apply()
    }

    fun getUserId(): Int = pref.getInt("userId", -1)

    fun getCredentials(): Pair<String, String> {
        val loginId = pref.getString("loginId", "") ?: ""
        val password = pref.getString("password", "") ?: ""
        return Pair(loginId, password)
    }
}