package com.example.achievements.util

import com.example.achievements.data_source.network.model.CustomResponseItem
import com.example.achievements.ui.main.state.AchievementsModel
import org.junit.Assert.*
import org.junit.Test


class MapperTest {

    private val expected = AchievementsModel(
        image = 2131230804,
        imageUrl = "https://restaurant-deployments-mobilehub-1797037487.s3.amazonaws.com/marathon.png?versionId=i5Am_g_Ajjn2IGBRI21CRIn5itQpLSVh",
        "marathon",
        "Not Yet",
        header = "a"
    )

    private val cutstomResponseItem = CustomResponseItem(
        image = 2131230804,
        imageUrl = "https://restaurant-deployments-mobilehub-1797037487.s3.amazonaws.com/marathon.png?versionId=i5Am_g_Ajjn2IGBRI21CRIn5itQpLSVh",
        title = "marathon",
        description = "Not Yet",
        header = "a"
    )

    @Test
    suspend fun `test mapCustomResponseToAchievementModel()`() {
        val cutstomResponse = ArrayList<CustomResponseItem>()
        val AchievementsList = ArrayList<AchievementsModel>()
        AchievementsList.add(expected)
        cutstomResponse.add(cutstomResponseItem)
        val res = Mapper.mapCustomResponseToAchievementModel(cutstomResponseItem)

        assertEquals(res.image, cutstomResponseItem.image)
        assertEquals(res.imageUrl, cutstomResponseItem.imageUrl)
        assertEquals(res.title, cutstomResponseItem.title)
        assertEquals(res.description, cutstomResponseItem.description)
        assertEquals(res.header, cutstomResponseItem.header)
    }
}