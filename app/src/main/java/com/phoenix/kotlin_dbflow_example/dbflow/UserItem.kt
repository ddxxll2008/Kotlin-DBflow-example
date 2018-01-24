package com.iflytek.mobilecontroltvserver.dbflow

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.structure.BaseModel

/**
 * Created by phoenix on 2018/1/24.
 */
@Table(name = "Users", database = AppDatabase::class)
class UserItem : BaseModel() {
    @PrimaryKey(autoincrement = true)
    @Column(name = "id")
    var id: Long = 0

    @Column(name = "name")
    var name: String = ""

    @Column(name = "sex")
    var sex: Int = 0
}