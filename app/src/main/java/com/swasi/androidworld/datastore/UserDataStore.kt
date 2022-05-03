package com.swasi.androidworld.datastore

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore

object UserDataStore {

    private const val USER_PREFERENCES_NAME = "user_preferences"

    val Context.dataStore by preferencesDataStore(
        name = USER_PREFERENCES_NAME
    )


}
