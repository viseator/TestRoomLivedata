package com.viseator.testroomlivedata

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import io.reactivex.Single

@Dao
interface UserDao {
    @Query("SELECT * FROM user WHERE uid = :uid LIMIT 1")
    fun findUserById(uid: String?): Single<User>

    @Query("SELECT * FROM user WHERE state = 1 LIMIT 1")
    fun findLoginUserWithObserve(): LiveData<User>

    @Query("SELECT * FROM user WHERE state =1 LIMIT 1")
    fun findLoginUser(): Single<User>

    @Update
    fun update(vararg user: User)

    @Insert
    fun insert(vararg user: User)

    @Delete
    fun delete(vararg user: User)
}