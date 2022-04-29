package com.swasi.androidworld.hilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.swasi.androidworld.R

/**
 * https://medium.com/androiddevelopers/a-pragmatic-guide-to-hilt-with-kotlin-a76859c324a1
 */
class HiltActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hilt)
    }
}