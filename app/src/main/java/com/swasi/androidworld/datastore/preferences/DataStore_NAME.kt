package com.swasi.androidworld.datastore.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.map
import javax.inject.Inject


const val DataStore_NAME = "PHONEBOOK"

val Context.datastore: DataStore<Preferences> by preferencesDataStore(name = DataStore_NAME)


class ImplRepository @Inject constructor(@ApplicationContext private val context: Context) :
    Abstract {

    override suspend fun savePhoneBook(userDetails: UserDetails) {
        context.datastore.edit { phonebooks ->
            phonebooks[PreferencesKeys.NAME] = userDetails.name!!
            phonebooks[PreferencesKeys.EMAIL] = userDetails.emailId!!
            phonebooks[PreferencesKeys.MOBILE] = userDetails.name!!
            phonebooks[PreferencesKeys.USER_AGE] = userDetails.age!!
            phonebooks[PreferencesKeys.IS_LOGGED_IN] = userDetails.isLoggedIn!!
            phonebooks[PreferencesKeys.LAST_LOGIN_MILLISECONDS] = userDetails.loggedInInMillis!!
            phonebooks[PreferencesKeys.USER_FLOAT] = userDetails.floatValue!!
            phonebooks[PreferencesKeys.USER_DOUBLE] = userDetails.doubleValue!!
        }

    }

    override suspend fun getPhoneBook() = context.datastore.data.map { phonebook ->
        UserDetails(
            name = phonebook[PreferencesKeys.NAME],
            emailId = phonebook[PreferencesKeys.EMAIL],
            mobile = phonebook[PreferencesKeys.MOBILE],
            age = phonebook[PreferencesKeys.USER_AGE],
            isLoggedIn = phonebook[PreferencesKeys.IS_LOGGED_IN],
            loggedInInMillis = phonebook[PreferencesKeys.LAST_LOGIN_MILLISECONDS],
            floatValue = phonebook[PreferencesKeys.USER_FLOAT],
            doubleValue = phonebook[PreferencesKeys.USER_DOUBLE]
        )
    }
}