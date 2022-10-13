package com.example.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.deeplinkdispatch.databinding.ActivityMainBinding
import com.example.navigation.AppLinkNavigation
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val appLinkNavigation : AppLinkNavigation by inject()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleClick()
    }

    private fun handleClick() = with(binding){
        buttonForFeatureTwo.setOnClickListener {
            appLinkNavigation.dispatchFrom(this@MainActivity, "foo://feature/two")
        }
        buttonForFeatureOne.setOnClickListener {
            appLinkNavigation.dispatchFrom(this@MainActivity, "foo://feature/one")
        }
    }
}