package com.viseator.testroomlivedata

import android.app.Application

/**
 * Created on 2018/9/11.
 * wudi.viseator@bytedance.com
 */

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        AccountManager.init(this)
    }
}