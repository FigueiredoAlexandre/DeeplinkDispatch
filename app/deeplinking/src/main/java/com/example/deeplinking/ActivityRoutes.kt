package com.example.deeplinking

import android.content.Context
import android.content.Intent
import com.airbnb.deeplinkdispatch.DeepLink
import com.airbnb.deeplinkdispatch.DeepLinkMethodResult
import com.example.featureone.FeatureOneActivity
import com.example.featuretwo.FeatureTwoActivity

object ActivityRoutes {

    @DeepLink("foo://feature/one")
    @JvmStatic
    fun navigateToFeatureOne(context: Context?) : DeepLinkMethodResult {
        return DeepLinkMethodResult(
            Intent(context, FeatureOneActivity::class.java)
        )
    }

    @DeepLink("foo://feature/two")
    @JvmStatic
    fun navigateTofeatureTwo(context: Context?) : DeepLinkMethodResult {
        return DeepLinkMethodResult(
            Intent(context, FeatureTwoActivity::class.java)
        )
    }
}