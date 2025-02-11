package com.example.achievements.data_source.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.achievements.data_source.room.model.AchievementsEntity


@Database(entities = [AchievementsEntity::class], version = 4,exportSchema = false)
abstract class AchievementsDatabase : RoomDatabase() {
    abstract fun achievementsDao(): AchievementsDao


    companion object{
        const val DATABASE_NAME: String = "badge_db"
    }
    /***
    injection is done in AppModule instead
     */

//    companion object {
//        val DATABASE_NAME: String = "badge_db"
//
//
//        @Volatile
//        private var INSTANCE: AchievementsDatabase? = null
//
//        fun getInstance(context: Context): AchievementsDatabase {
//            // Multiple threads can ask for the database at the same time, ensure we only initialize
//            // it once by using synchronized. Only one thread may enter a synchronized block at a
//            // time.
//            synchronized(this) {
//
//                // Copy the current value of INSTANCE to a local variable so Kotlin can smart cast.
//                // Smart cast is only available to local variables.
//                var instance = INSTANCE
//
//                // If instance is `null` make a new database instance.
//                if (instance == null) {
//                    instance = Room.databaseBuilder(
//                        context.applicationContext,
//                        AchievementsDatabase::class.java,
//                        DATABASE_NAME
//                    )
//                        // Wipes and rebuilds instead of migrating if no Migration object.
//                        // Migration is not part of this lesson. You can learn more about
//                        // migration with Room in this blog post:
//                        // https://medium.com/androiddevelopers/understanding-migrations-with-room-f01e04b07929
//                        .fallbackToDestructiveMigration()
//                        .build()
//                    // Assign INSTANCE to the newly created database.
//                    INSTANCE = instance
//                }
//
//                // Return instance; smart cast to be non-null.
//                return instance
//            }
//        }
//    }
}