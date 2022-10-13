package com.example.featureone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.featureone.databinding.FeatureOneActivityLayoutBinding
import com.example.navigation.AppLinkNavigation
import org.koin.android.ext.android.inject

class FeatureOneActivity : AppCompatActivity() {

    private val appLinkNavigation: AppLinkNavigation by inject()
    private lateinit var binding: FeatureOneActivityLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FeatureOneActivityLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onClick()
    }

    private fun onClick() = with(binding.featureOneButton) {
        setOnClickListener {
            appLinkNavigation.dispatchFrom(this@FeatureOneActivity, "foo://feature/two")
        }
    }
}