package com.viseator.testroomlivedata

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "user", primaryKeys = ["uid"])
class User {
    @ColumnInfo(name = "uid")
    var uid: String = ""

    @ColumnInfo(name = "user_name")
    var userName: String? = null

    @ColumnInfo(name = "state")
    var state: Int = STATE_NOT_LOGIN


    companion object {
        val STATE_NOT_LOGIN = 0
        val STATE_HAVE_LOGIN = 1
    }

    override fun toString(): String {
        return "User(uid='$uid', userName=$userName, state=$state)"
    }
}