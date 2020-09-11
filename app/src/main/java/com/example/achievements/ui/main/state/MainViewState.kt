package com.example.achievements.ui.main.state

/***
 * this is created to to migrate from MVVM to MVI by Armin Mehran
 * ***/


data class MainViewState(
    val message: String,
    var data: ArrayList<AchievementsModel>?
)