package com.example.navigation

import android.content.Context
import com.airbnb.deeplinkdispatch.DeepLinkResult

interface AppLinkNavigation {

    fun dispatchFrom(
        context: Context?,
        url: String
    ) : DeepLinkResult
}