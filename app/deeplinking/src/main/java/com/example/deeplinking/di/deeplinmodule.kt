package com.example.deeplinking.di

import com.airbnb.deeplinkdispatch.BaseDeepLinkDelegate
import com.example.deeplinking.AppLinkModuleRegistry
import com.example.deeplinking.activity.DeepLinkDelegate
import com.example.deeplinking.finder.DeepLinkFinder
import com.example.deeplinking.finder.DeepLinkFinderImpl
import com.example.deeplinking.navigation.AppLinkNavigationImpl
import com.example.navigation.AppLinkNavigation
import org.koin.dsl.module

val deepLinkModule = module {

    single<BaseDeepLinkDelegate> {
        DeepLinkDelegate(AppLinkModuleRegistry())
    }
    factory<AppLinkNavigation> {
        AppLinkNavigationImpl(
            baseDeepLinkDelegate = get()
        )
    }
    factory<DeepLinkFinder> {
        DeepLinkFinderImpl(
            get<AppLinkModuleRegistry>()
        )
    }
}