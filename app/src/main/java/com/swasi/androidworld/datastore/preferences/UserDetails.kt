package com.swasi.androidworld.datastore.preferences

data class UserDetails(
    val name: String?,
    val emailId: String?,
    val mobile: String?,
    val isLoggedIn: Boolean?,
    val age: Int?,
    val loggedInInMillis: Long?,
    val floatValue: Float?,
    val doubleValue: Double?
)