package com.example.achievements.ui.main.state

/***
 * this is created to to migrate from MVVM to MVI by Armin Mehran
 * ***/

sealed class MainStateEvent {
    object UpdateLocalCacheEvent : MainStateEvent()
    object ClearLocalCacheEvent : MainStateEvent()
    class NavigateToDetailedScreenEvent(title: String, image: Int) : MainStateEvent()
//    object NothingEvent : MainStateEvent()

}