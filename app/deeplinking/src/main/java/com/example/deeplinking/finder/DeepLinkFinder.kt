package com.example.deeplinking.finder

import com.airbnb.deeplinkdispatch.DeepLinkEntry

interface DeepLinkFinder {

    fun find(deepLinkEntry: String): DeepLinkEntry?
}