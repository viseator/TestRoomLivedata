package com.viseator.testroomlivedata

import android.app.Application
import android.util.Log
import androidx.lifecycle.Observer
import androidx.room.Room.databaseBuilder
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

object AccountManager {
    private const val DATA_BASE_NAME = "users"
    val TAG = "AccountManager"
    fun init(context: Application) {
        sDb = databaseBuilder(context, UserDataBase::class.java, DATA_BASE_NAME).build()
        sDao = sDb.userDao()
        sDao.findLoginUserWithObserve().observeForever {
            Log.d(TAG, "notified: $it")
        }
    }

    private lateinit var sDb: UserDataBase
    private lateinit var sDao: UserDao

    fun findLoginUserWithObserve() = sDao.findLoginUserWithObserve()

    fun logoutFlowable(): Single<Boolean> = sDao.findLoginUser().subscribeOn(
            Schedulers.io()).map { user ->
        user.state = User.STATE_NOT_LOGIN
        sDao.update(user)
        true
    }

    fun login(user: User) = logoutFlowable().subscribe({ doLogin(user) }, { doLogin(user) })

    private fun doLogin(user: User) = sDao.findUserById(user.uid).subscribeOn(
            Schedulers.io()).subscribe({ origin ->
        origin.userName = user.userName
        origin.state = User.STATE_HAVE_LOGIN
        sDao.update(origin)
        user.state = User.STATE_HAVE_LOGIN
    }, {
        user.state = User.STATE_HAVE_LOGIN
        sDao.insert(user)
    })

}