package com.iflytek.mobilecontroltvserver.dbflow

import com.raizlabs.android.dbflow.kotlinextensions.select
import com.raizlabs.android.dbflow.sql.language.Select

/**
 * Created by phoenix on 2018/1/24.
 */
object ItemRepository {
    fun getAll(): MutableList<UserItem> {
        return Select()
                .from(UserItem::class.java)
                .where()
                .orderBy(UserItem_Table.id, true)
                .queryList()
    }
}