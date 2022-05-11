package com.swasi.androidworld.datastore.preferences

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.lifecycleScope
import com.swasi.androidworld.databinding.ActivityDatastorePreferenceBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_datastore_preference.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
class DatastorePreferenceActivity : AppCompatActivity() {

    private var isLoggedIn: Boolean = false
    private var count: Int = 0
    lateinit var binding: ActivityDatastorePreferenceBinding
    private val activityViewModel: DataStorePrefViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDatastorePreferenceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        binding.viewModel = activityViewModel

        btnCount.setOnClickListener {
            lifecycleScope.launch {
                increment()
            }
        }

        println("Before RunBlocking $count")
        runBlocking {
            getCount()
            println("Inside RunBlocking $count")
            delay(5000)
        }
        println("After RunBlocking")
//        val result = getCount()
//        println("Result is $result")
    }

    private suspend fun showMyToast() {
        if (isLoggedIn) {
            Toast.makeText(this, "Logged In", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Not Logged In", Toast.LENGTH_SHORT).show()
            lifecycleScope.launch {
                datastore.edit {
                    it[PreferencesKeys.IS_LOGGED_IN] = true
                }
            }
        }
    }

    private suspend fun increment() {
        var count1: Int = 0
        datastore.data.map {
            count1 = it[PreferencesKeys.COUNT]!!
        }

        count1++

        datastore.edit {
            it[PreferencesKeys.COUNT] = count1
        }
        btnCount.text = "Count $count1"
    }

    private suspend fun fetchCount() = runBlocking {
        try {
            datastore.data.map {
                it[PreferencesKeys.COUNT]
            }.collect {
                count = it!!
                btnCount.text = "Count $count"
            }
        } catch (e: Exception) {
            Log.i("TAG", "Exception ${e.message}")
            datastore.edit {
                it[PreferencesKeys.COUNT] = 0
            }
        }
    }

    private fun getCount() {
        lifecycleScope.launch {
            datastore.data.map {
                it[PreferencesKeys.COUNT]
            }.collect {
                count = it ?: 0
            }
        }
    }
}