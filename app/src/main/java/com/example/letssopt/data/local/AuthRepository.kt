package com.example.letssopt.data.local

import android.content.Context

class AuthRepository(context: Context) {
    private val pref = context.getSharedPreferences("LoginPref", Context.MODE_PRIVATE)

    fun isAutoLoginAvailable(): Boolean {
        val email = pref.getString("email", null)
        val password = pref.getString("password", null)
        return !email.isNullOrEmpty() && !password.isNullOrEmpty()
    }

    fun saveLogin(email: String, password: String) {
        pref.edit()
            .putString("email", email)
            .putString("password", password)
            .apply()
    }

    fun saveUserId(userId: Int) {
        pref.edit().putInt("userId", userId).apply()
    }

    fun getUserId(): Int = pref.getInt("userId", -1)

    fun getCredentials(): Pair<String, String> {
        val email = pref.getString("email", "") ?: ""
        val password = pref.getString("password", "") ?: ""
        return Pair(email, password)
    }
}