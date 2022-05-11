package com.swasi.androidworld.datastore.preferences

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Created by Sibaprasad Mohanty on 04/05/2022.
 * siba.x.prasad@gmail.com
 */


@HiltViewModel
class DataStorePrefViewModel @Inject constructor(private val implRepository: ImplRepository) :
    ViewModel() {

    var name: MutableLiveData<String> = MutableLiveData("")
    var emailId: MutableLiveData<String> = MutableLiveData("")
    var mobile: MutableLiveData<String> = MutableLiveData("")
    var age: MutableLiveData<Int> = MutableLiveData(0)
    var isLoggedIN: MutableLiveData<Boolean> = MutableLiveData(false)
    var lastLoggedInMillis: MutableLiveData<Long> = MutableLiveData(0)
    var floatValue: MutableLiveData<Float> = MutableLiveData(0.0f)
    var doubleValue: MutableLiveData<Double> = MutableLiveData(0.0)

    var userDetails: MutableLiveData<UserDetails> = MutableLiveData()

    fun saveData() {
        viewModelScope.launch(Dispatchers.IO) {
            implRepository.savePhoneBook(
                UserDetails(
                    name = name.value,
                    emailId = emailId.value,
                    mobile = mobile.value,
                    age = age.value,
                    isLoggedIn = isLoggedIN.value,
                    loggedInInMillis = lastLoggedInMillis.value,
                    floatValue = floatValue.value,
                    doubleValue = doubleValue.value
                )
            )
        }
    }

    fun retrieveDate() {
        viewModelScope.launch(Dispatchers.IO) {
            implRepository.getPhoneBook().collect {
                userDetails.postValue(it)
            }
        }
    }
}