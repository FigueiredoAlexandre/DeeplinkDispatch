package com.example.featuretwo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.deeplinkdispatch.DeepLink
import com.example.featuretwo.databinding.FeatureTwoActivityLayoutBinding
import com.example.navigation.AppLinkNavigation
import org.koin.android.ext.android.inject

@DeepLink("foo://feature/two")
class FeatureTwoActivity: AppCompatActivity() {

    private val appLinkNavigation: AppLinkNavigation by inject()
    private lateinit var binding:FeatureTwoActivityLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FeatureTwoActivityLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleClick()
    }

    private fun handleClick() = with(binding.featureTwoButton) {
        setOnClickListener {
            appLinkNavigation.dispatchFrom(this@FeatureTwoActivity,"foo://feature/one" )
        }
    }
}