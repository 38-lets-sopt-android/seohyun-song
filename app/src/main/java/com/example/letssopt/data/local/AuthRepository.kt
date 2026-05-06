package com.example.letssopt.data.local

import android.content.Context

class AuthRepository(context: Context) {
    private val pref = context.getSharedPreferences("LoginPref", Context.MODE_PRIVATE)

    fun isAutoLoginAvailable(): Boolean {
        val email = pref.getString("email", null)
        val password = pref.getString("password", null)
        return !email.isNullOrEmpty() && !password.isNullOrEmpty()
    }

    fun saveLogin(email:String, password: String) {
        pref.edit()
            .putString("email", email)
            .putString("password", password)
            .apply()
    }
}