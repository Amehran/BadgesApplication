package com.example.achievements.data_source.network

import com.example.achievements.data_source.network.model.CustomResponseItem
import retrofit2.Response
import retrofit2.http.GET

/***
 * a very simple interface to get all the badges need to show in Recycler view
 * the /live/loyalty was related to another project on AWS of mine which to save time I
 * modified it to be usable for this app.
 */

interface ApiService {
    @GET("/live/loyalty/")
    suspend fun getAllBadges(): Response<List<CustomResponseItem>>


}