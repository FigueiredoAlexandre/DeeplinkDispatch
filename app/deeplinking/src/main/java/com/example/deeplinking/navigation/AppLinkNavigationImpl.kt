package com.example.deeplinking.navigation

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import com.airbnb.deeplinkdispatch.BaseDeepLinkDelegate
import com.airbnb.deeplinkdispatch.DeepLinkResult
import com.example.navigation.AppLinkNavigation

class AppLinkNavigationImpl(
    private val baseDeepLinkDelegate: BaseDeepLinkDelegate
) : AppLinkNavigation {


    override fun dispatchFrom(context: Context?, url: String): DeepLinkResult =
        baseDeepLinkDelegate.dispatchFrom(
            context as Activity,
            Intent(Intent.ACTION_VIEW, Uri.parse(url))
        ).run {
            DeepLinkResult(
                isSuccessful, uriString, error
            )
        }

}