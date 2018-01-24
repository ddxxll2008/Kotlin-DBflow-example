package com.phoenix.kotlin_dbflow_example

import android.app.Application
import com.raizlabs.android.dbflow.config.FlowConfig
import com.raizlabs.android.dbflow.config.FlowManager

/**
 * Created by phoenix on 2018/1/24.
 */
class DatabaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        FlowManager.init(FlowConfig.Builder(this).build())
    }

    override fun onTerminate() {
        super.onTerminate()
        FlowManager.destroy()
    }
}