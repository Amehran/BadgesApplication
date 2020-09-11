package com.example.achievements.data_source.fake_data

import com.example.achievements.ui.main.state.AchievementsModel

/***
 * this is the hardcoded data source. a faked REST API endpoint is created on AWS as well.
 * they both act the same.
 */

abstract class FakeEmptyDataSource {

    companion object {

        fun createDataSet(): ArrayList<AchievementsModel> {
            val list = ArrayList<AchievementsModel>()
            list.add(
                AchievementsModel(
                    image = null,
                    imageUrl = null,
                    title = null,
                    description = null,
                    header = null
                )
            )


            return list
        }
    }
}