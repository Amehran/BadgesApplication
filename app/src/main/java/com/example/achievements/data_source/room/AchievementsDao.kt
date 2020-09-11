package com.example.achievements.data_source.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.achievements.data_source.room.model.AchievementsEntity

@Dao
interface AchievementsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBadge(badge: AchievementsEntity) : Long

    @Query("SELECT * FROM badges")
    suspend fun getAllBadges() : List<AchievementsEntity>

    @Query("DELETE FROM badges")
    suspend fun deleteAll()
}