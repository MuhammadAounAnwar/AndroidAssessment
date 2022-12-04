package com.ono.androidassessment.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.ono.androidassessment.UserAgeModel


@Dao
interface UserDao {

    @Insert(onConflict = REPLACE)
    fun insertNewDetail(userAgeModel: UserAgeModel)


    @Query("Select * from UserAgeModel")
    fun getAllUsersDetails(): LiveData<List<UserAgeModel>>
}