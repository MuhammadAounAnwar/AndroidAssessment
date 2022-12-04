package com.ono.androidassessment

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "UserAgeModel")
data class UserAgeModel(
    @PrimaryKey(autoGenerate = true) @Expose @SerializedName("id") var id: Int = 0,
    @ColumnInfo(name = "name") @Expose @SerializedName("name") var name: String? = "",
    @ColumnInfo(name = "age") @Expose @SerializedName("age") var age: Int? = 0,
    @ColumnInfo(name = "count") @Expose @SerializedName("count") var count: Int? = 0
)
