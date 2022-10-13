package com.example.deeplinking.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.deeplinkdispatch.DeepLinkHandler
import com.example.deeplinking.AppLinkModule
import com.example.deeplinking.AppLinkModuleRegistry

@DeepLinkHandler(AppLinkModule::class)
class DeepLinkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val deepLinkDelegate = DeepLinkDelegate(AppLinkModuleRegistry())

        deepLinkDelegate.dispatchFrom(this)

    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent?) {
        val deepLinkDelegate = DeepLinkDelegate(AppLinkModuleRegistry())
        intent?.let {
            val deepLinkDispatch = deepLinkDelegate.dispatchFrom(this, it)
        }
        finish()
    }
}