package com.walltip.core.analytics

import com.microsoft.appcenter.analytics.Analytics

/**
 * Created by amresh on 28/07/2019
 */
object Tracker {

    fun trackClickEvents(eventName: String, data: HashMap<String, String>) {
        Analytics.trackEvent(eventName, data)
    }


}
