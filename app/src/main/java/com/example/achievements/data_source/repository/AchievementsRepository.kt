package com.example.achievements.data_source.repository

import android.util.Log
import com.example.achievements.data_source.fake_data.FakeEmptyDataSource
import com.example.achievements.data_source.network.ApiService
import com.example.achievements.data_source.room.AchievementsDao
import com.example.achievements.ui.main.state.MainViewState
import com.example.achievements.util.Mapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

import javax.inject.Inject

/***
 * this the repository class that is used in MVVM architecture to switch and access the local and remote data sources.
 * checks can be performed here to get the status of teh network connection and act on the:
    - success response
    - error response
    - empty response.
 * a generic response wrapper class can also be used here
 ***/

class AchievementsRepository @Inject constructor(

    private val dao: AchievementsDao,
    private val api: ApiService,
) {

    suspend fun getAllBadges(): MainViewState {
        //  check database as single source of truth
        //  if valid data exists then return back the results 
        //  else: get the correct data from network, save it to database  and return back aa

        val badgesFromDatabase = getAllBadgesFromDatabase()


        return if (badgesFromDatabase.isNotEmpty()) {    // checks if database has the right data
            Log.d("MyTag", "from db")
            MainViewState(
                message = "OK",
                data = Mapper.mapAchievementsEntityToAchievementModel(badgesFromDatabase)
            )
        } else { // gets the data from network and updates the local dataBase
            //  check connectivity: crashes when no network
            val res = withContext(Dispatchers.IO) { api.getAllBadges() }
            //  more checks can be done here based on the res.message, res.code etc
            when (res.message()) {
                "OK" -> {
                    Log.d("MyTag", "from Network")
                    withContext(Dispatchers.IO) {
                        res.body()?.forEach {
                            dao.insertBadge(
                                Mapper.mapCustomResponseToAchievementEntity(it)
                            )
                        }

                        MainViewState(
                            message = res.message(),
                            data = Mapper.mapAchievementsEntityToAchievementModel(getAllBadgesFromDatabase()) //Mapper.mapFromCustomResponseToAchievementModel(res.body())
                        )
                    }
                }
                else -> {
                    MainViewState(
                        message = "Error",
                        data = FakeEmptyDataSource.createDataSet()
                    )
                }
            }
        }
    }

    private suspend fun getAllBadgesFromDatabase() =
        withContext(Dispatchers.IO) { dao.getAllBadges() }


    suspend fun clearAllBadgesFromDatabase() = withContext(Dispatchers.IO) {dao.deleteAll()}

}

