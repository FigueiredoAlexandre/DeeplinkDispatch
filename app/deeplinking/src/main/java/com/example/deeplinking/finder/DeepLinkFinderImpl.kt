package com.example.deeplinking.finder

import com.airbnb.deeplinkdispatch.BaseRegistry
import com.airbnb.deeplinkdispatch.DeepLinkEntry
import com.airbnb.deeplinkdispatch.DeepLinkUri
import com.example.deeplinking.AppLinkModuleRegistry

class DeepLinkFinderImpl(
    private val loaders: List<BaseRegistry>
) : DeepLinkFinder {

    constructor(appLinkModuleRegistry: AppLinkModuleRegistry): this(listOf(appLinkModuleRegistry))

    override fun find(deepLinkEntry: String): DeepLinkEntry? {
        for(loader in loaders) {
            val deepLinkUri = DeepLinkUri.parse(deepLinkEntry)
            val entry = loader.idxMatch(deepLinkUri)
            if(entry?.deeplinkEntry != null) {
                return entry.deeplinkEntry
            }
        }
        return null
    }
}