package com.example.achievements.ui.achievements

import com.example.achievements.ui.main.state.AchievementsModel

interface OnClickListener {
    fun onItemClicked(item: AchievementsModel, position : Int)
}