package com.partners.texsun.app

import android.app.Application
import com.partners.texsun.app.utils.TexsunLifeCycleCallback
import io.paperdb.Paper

class TexsunApp : Application() {
    val activityLifecycleCallback = TexsunLifeCycleCallback()
    companion object {
        var instance = TexsunApp()

    }
    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(activityLifecycleCallback)
        instance = this
        Paper.init(applicationContext)
    }
}