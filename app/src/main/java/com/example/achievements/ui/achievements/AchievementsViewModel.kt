package com.example.achievements.ui.achievements

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.achievements.data_source.repository.AchievementsRepository
import kotlinx.coroutines.launch

/***
 * this is created to implement MVVM architecture.
 * additional changed are half done to migrate into MVI by Armin Mehran
 * please Note it is not complete yet as it will exceed the 8 hrs window
 * ***/

class AchievementsViewModel @ViewModelInject constructor(
    private val repository: AchievementsRepository
) : ViewModel() {
    //  one-shot data from repository
    val badges = liveData { emit(repository.getAllBadges()) }

    // private MutableLivedata and public liveData pattern

    fun clear() {
        Log.d("MyTag", " Clear just called")
        viewModelScope.launch { repository.clearAllBadgesFromDatabase() }
    }

    fun reloadData() = viewModelScope.launch {  repository.getAllBadges()}
}