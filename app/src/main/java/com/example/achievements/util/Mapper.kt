package com.example.achievements.util

import com.example.achievements.R
import com.example.achievements.ui.main.state.AchievementsModel
import com.example.achievements.data_source.network.model.CustomResponseItem
import com.example.achievements.data_source.room.model.AchievementsEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Mapper {
    companion object {
        suspend fun mapAchievementsEntityToAchievementModel(list: List<AchievementsEntity>?): ArrayList<AchievementsModel> {
            val res = ArrayList<AchievementsModel>()
            withContext(Dispatchers.IO) {
                list.let {
                    for (entity in list!!) {
                        res.add(
                            AchievementsModel(
                                image = R.id.badge_description,
                                imageUrl = entity.imageUrl,
                                title = entity.title,
                                description = entity.description,
                                header = entity.header
                            )
                        )
                    }
                }
            }
            return res
        }

        fun mapCustomResponseToAchievementModel(list: CustomResponseItem?): AchievementsModel {
            list.let {
                return AchievementsModel(
                    image = R.id.badge_description,
                    imageUrl = it?.imageUrl,
                    title = it?.title,
                    description = it?.description,
                    header = it?.header
                )
            }
        }

        fun mapCustomResponseToAchievementEntity(res: CustomResponseItem?): AchievementsEntity {

            res.let {
                return AchievementsEntity(
                    image = R.id.badge_description,
                    imageUrl = it?.imageUrl,
                    title = it?.title,
                    description = it?.description,
                    header = it?.header
                )
            }
        }

    }
}