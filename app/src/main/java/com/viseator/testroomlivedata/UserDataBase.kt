package com.viseator.testroomlivedata

import androidx.room.Database
import androidx.room.RoomDatabase
import com.viseator.testroomlivedata.User

/** * Created on 2018/7/23. * weiwenpei@bytedance.com */
@Database(version = 1, entities = [(User::class)], exportSchema = false)
abstract class UserDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao
}