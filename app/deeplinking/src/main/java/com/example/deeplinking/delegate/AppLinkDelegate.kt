package com.example.deeplinking.delegate

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.example.deeplinking.finder.DeepLinkFinder
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class AppLinkDelegate : KoinComponent {

    private val deepLinkFinder: DeepLinkFinder by inject()

    fun dispatchFrom(
        context: Context?,
        uri: Uri
    ) {
        val entry = deepLinkFinder.find(uri.toString())

        try {
            if (entry != null) {
                Intent(context, entry.clazz).also {
                    context?.startActivity(it)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}