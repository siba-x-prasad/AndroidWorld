package com.swasi.androidworld.datastore.preferences

import kotlinx.coroutines.flow.Flow

interface Abstract {
    suspend fun savePhoneBook(UserDetails: UserDetails)
    suspend fun getPhoneBook(): Flow<UserDetails>
}