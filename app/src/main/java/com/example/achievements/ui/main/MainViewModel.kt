package com.example.achievements.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.achievements.data_source.fake_data.FakeEmptyDataSource
import com.example.achievements.data_source.repository.AchievementsRepository
import com.example.achievements.ui.achievements.AchievementsViewModel
import com.example.achievements.ui.main.state.MainStateEvent
import com.example.achievements.ui.main.state.MainViewState

/***
 * This view model is created and will be replaced with the AchievementsViewModel.
 * the Activity will host this and fragments associated with that activity will share the same viewModel
 * and It will utilize the full MVI pattern
 *
 ***/

class MainViewModel @ViewModelInject constructor(
    private val repository: AchievementsRepository
) : ViewModel() {
    private val _stateEvent: MutableLiveData<MainStateEvent> = MutableLiveData()
    private val _viewState: MutableLiveData<MainViewState> = MutableLiveData()

    private val viewState: LiveData<MainViewState>
        get() = _viewState


    val dataState: LiveData<MainViewState> = Transformations
        .switchMap(_stateEvent) { stateEvent ->
            stateEvent?.let {
                handleStateEvent(stateEvent)
            }
        }


    private fun handleStateEvent(stateEvent: MainStateEvent): LiveData<MainViewState> {
        println("DEBUG: New StateEvent detected: $stateEvent")
        return when (stateEvent) {

            is MainStateEvent.ClearLocalCacheEvent -> {
                liveData {
                    MainViewState(
                        message = "Error",
                        data = FakeEmptyDataSource.createDataSet()
                    )
                } // clear cache

            }
            is MainStateEvent.NavigateToDetailedScreenEvent -> {
                liveData {
                    MainViewState(
                        message = "Error",
                        data = FakeEmptyDataSource.createDataSet()
                    )
                } // clear cache

            }
            is MainStateEvent.UpdateLocalCacheEvent -> {
                liveData {
                    getBadgesFromNetwork()
                }

            }
            else -> {
                return liveData {
                    MainViewState(
                        message = "Error",
                        data = FakeEmptyDataSource.createDataSet()
                    )
                } // clear cache
            }
        }
    }

    suspend fun setBadgeListData(achievementsViewModel: ArrayList<AchievementsViewModel>) {
        val update = repository.getAllBadges()
        _viewState.value = update
    }

    private suspend fun getBadgesFromNetwork() = repository.getAllBadges()

    fun getCurrentViewStateOrNew(): MainViewState {
        return viewState.value ?: MainViewState(
            message = "Error",
            data = FakeEmptyDataSource.createDataSet()
        )
    }

    fun setStateEvent(event: MainStateEvent) {
        val state: MainStateEvent = event
        _stateEvent.value = state
    }
}