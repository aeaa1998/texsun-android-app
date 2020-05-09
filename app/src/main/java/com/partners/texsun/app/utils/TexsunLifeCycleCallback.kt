package com.partners.texsun.app.utils

import android.app.Activity
import android.app.Application
import android.os.Bundle

class TexsunLifeCycleCallback :  Application.ActivityLifecycleCallbacks {
    private val set = hashSetOf<Activity>()
    override fun onActivityPaused(p0: Activity) {

    }

    override fun onActivityStarted(p0: Activity) {
        set.add(p0)

    }

    override fun onActivityDestroyed(p0: Activity) {
    }

    override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
    }

    override fun onActivityStopped(p0: Activity) {
        set.remove(p0)

    }

    override fun onActivityCreated(p0: Activity, p1: Bundle?) {
    }

    override fun onActivityResumed(p0: Activity) {
    }

    fun getCurrentActivity(): Activity? {
        if (set.isEmpty()) {
            return null
        }
        return set.iterator().next()
    }
}