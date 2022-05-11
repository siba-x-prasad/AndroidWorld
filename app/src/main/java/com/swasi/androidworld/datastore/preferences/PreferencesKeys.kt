package com.swasi.androidworld.datastore.preferences

import androidx.datastore.preferences.core.*

object PreferencesKeys {
    val NAME = stringPreferencesKey("userName")
    val EMAIL = stringPreferencesKey("emailId")
    val MOBILE = stringPreferencesKey("mobileNumber")
    val IS_LOGGED_IN = booleanPreferencesKey("isLoggedIn")
    val USER_AGE = intPreferencesKey("AGE")
    val LAST_LOGIN_MILLISECONDS = longPreferencesKey("lastLoggedInMillis")
    val USER_DOUBLE = doublePreferencesKey("doubleValue")
    val USER_FLOAT = floatPreferencesKey("floatValue")
    val COUNT = intPreferencesKey("count")
}