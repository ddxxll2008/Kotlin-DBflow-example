package com.iflytek.mobilecontroltvserver.dbflow

import com.raizlabs.android.dbflow.annotation.Database

/**
 * Created by phoenix on 2018/1/24.
 */
@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION)
object AppDatabase {
    const val NAME: String = "TvUsers"
    const val VERSION: Int = 1
}