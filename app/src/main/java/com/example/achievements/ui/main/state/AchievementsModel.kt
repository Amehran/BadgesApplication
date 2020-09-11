package com.example.achievements.ui.main.state


/***
 * this is created as the business model/logic that is going to be used to update the UI
 * in the MVI this will be similar and in future replaced by ViewState Model. e.g: the MainViewState class
 */
data class AchievementsModel (
    //  var image: String,
    val image: Int?,
    val imageUrl: String?,
    val title: String?,
    val description: String?, // Author of blog post
    val header: String? = null

) {
    override fun toString(): String {
        return "Achievement(image='$image', imageUrl='$imageUrl',title='$title', description='$description',header='$header')"
    }
}
