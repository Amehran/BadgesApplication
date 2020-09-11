package com.example.achievements.data_source.fake_data

import com.example.achievements.R
import com.example.achievements.ui.main.state.AchievementsModel

/***
 * this is the hardcoded data source. a faked REST API endpoint is created on AWS as well.
 * they both act the same.
 */

abstract class FakeDataSource {

    companion object {

        fun createDataSet(): ArrayList<AchievementsModel> {
            val list = ArrayList<AchievementsModel>()
            list.add(
                AchievementsModel(
                    image = null,
                    imageUrl = null,
                    title = null,
                    description = null,
                    header = "Personal Records"
                )
            )
            list.add(
                AchievementsModel(
                    image = null,
                    imageUrl = null,
                    title = null,
                    description = null,
                    header = ""
                )
            )

            list.add(
                AchievementsModel(
                    R.drawable.longest_run,
                    imageUrl = "https://restaurant-deployments-mobilehub-1797037487.s3.amazonaws.com/longest_run.png?versionId=ZZUW5eLD9wn2m.UFs0lho8Ya_7s_vWZH",
                    "Longest Run",
                    "00:00",
                    header = null
                )
            )
            list.add(
                AchievementsModel(
                    R.drawable.highest_elevation,
                    imageUrl = "https://restaurant-deployments-mobilehub-1797037487.s3.amazonaws.com/highest_elevation.png?versionId=qD_rZA811jwmrIE4A0wacr7Yzrg5tJ4P",
                    "Highest Elevation",
                    "2501 ft",
                    header = null
                )
            )
            list.add(
                AchievementsModel(
                    R.drawable.fastest_5k,
                    imageUrl = "https://restaurant-deployments-mobilehub-1797037487.s3.amazonaws.com/fastest_5k.png?versionId=hRBcZWP6YlaRHDKIB3NQ6YY8ZCtpIOOu",
                    "Fastest 5K",
                    "00:00",
                    header = null
                )
            )
            list.add(
                AchievementsModel(
                    R.drawable.k10,
                    imageUrl = "https://restaurant-deployments-mobilehub-1797037487.s3.amazonaws.com/k10.png?versionId=Z6qniiixiDXtZndeIK2qd91Y5ZgNLMKK",
                    "10K",
                    "00:00:00",
                    header = null
                )
            )
            list.add(
                AchievementsModel(
                    R.drawable.half_marathon,
                    imageUrl = "https://restaurant-deployments-mobilehub-1797037487.s3.amazonaws.com/half_marathon.png?versionId=6lSHF5eebdWHHNeFKceesR2GFaTvDMsn",
                    "Half Marathon",
                    "00:00",
                    header = null
                )
            )
            list.add(
                AchievementsModel(
                    R.drawable.marathon,
                    imageUrl = "https://restaurant-deployments-mobilehub-1797037487.s3.amazonaws.com/marathon.png?versionId=i5Am_g_Ajjn2IGBRI21CRIn5itQpLSVh",
                    "Marathon",
                    "Not Yet",
                    header = null
                )
            )
            list.add(
                AchievementsModel(
                    image = null,
                    imageUrl = null,
                    title = null,
                    description = null,
                    header = "Virtual Races"
                )
            )
            list.add(
                AchievementsModel(
                    image = null,
                    imageUrl = null,
                    title = null,
                    description = null,
                    header = ""
                )
            )
            list.add(
                AchievementsModel(
                    R.drawable.virtual_half_marathon,
                    imageUrl = "https://restaurant-deployments-mobilehub-1797037487.s3.amazonaws.com/half_marathon.png",
                    "Virtual Half Marathon",
                    "00:00",
                    header = null
                )
            )

            list.add(
                AchievementsModel(
                    R.drawable.tokyo_hakone,
                    imageUrl = "https://restaurant-deployments-mobilehub-1797037487.s3.amazonaws.com/tokyo_hakone.png?versionId=Wg2M.nLzOJiTjp9rxmjkUIeyBrSzH4eX",
                    "Tokyo-Hakone Ekiden 2020",
                    "00:00:00",
                    header = null
                )
            )
            list.add(
                AchievementsModel(
                    R.drawable.virtual_10k,
                    imageUrl = "https://restaurant-deployments-mobilehub-1797037487.s3.amazonaws.com/virtual_10k.png?versionId=SI61r4kC5gMsrW9CMlICpsWC1DsjnwvB",
                    "Virtual 10K Race",
                    "00:00:00",
                    header = null
                )
            )
            list.add(
                AchievementsModel(
                    R.drawable.hakone_ekiden,
                    imageUrl = "https://restaurant-deployments-mobilehub-1797037487.s3.amazonaws.com/hakone_ekiden.png?versionId=9bG4WPgcyXgvKavwIYVVTWcKVD.Lvjc5",
                    "Hakone Ekiden",
                    "00:00:00",
                    header = null
                )
            )
            list.add(
                AchievementsModel(
                    R.drawable.mizuno,
                    imageUrl = "https://restaurant-deployments-mobilehub-1797037487.s3.amazonaws.com/mizuno.png?versionId=Hml8HtZztYMv.X.aKxgoTACs6qOHR_3q",
                    "Mizuno Singapore Ekiden 2015",
                    "00:00:00",
                    header = null
                )
            )
            list.add(
                AchievementsModel(
                    R.drawable.virtual_5k_race,
                    imageUrl = "https://restaurant-deployments-mobilehub-1797037487.s3.amazonaws.com/virtual_5k_race.png?versionId=.OSoxhJZ2EdsDHx.828PfyMPa9N.NKw5",
                    "Virtual 5K Race",
                    "23:77",
                    header = null
                )
            )

            return list
        }
    }
}