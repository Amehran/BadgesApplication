package com.example.achievements.data_source.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/***
 * the model class used with room to implement the local cache.
 * the reference to the Room Database and Dao is provided through Hilt.
 * check the appModule in di package for more info
 */
@Entity(tableName = "badges")
data class AchievementsEntity (

    var image: Int?,
    var imageUrl: String?,
    var title: String?,
    var description: String?, // Author of blog post
    var header: String?
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0
}