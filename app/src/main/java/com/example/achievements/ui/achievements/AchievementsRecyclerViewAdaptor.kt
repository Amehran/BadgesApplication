package com.example.achievements.ui.achievements

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.achievements.ui.main.state.AchievementsModel
import com.example.achievements.util.fadeOut
import com.example.achievements.R
import com.example.achievements.data_source.fake_data.FakeEmptyDataSource
import com.example.achievements.util.fadeIn
import kotlinx.android.synthetic.main.layout_badge_list_item.view.*
import kotlinx.android.synthetic.main.layout_header_list_item.view.*
import javax.inject.Inject


class AchievementsRecyclerViewAdaptor @Inject constructor(
    list: ArrayList<AchievementsModel>,
    private var clickListener: OnClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var _items = list

//    fun setAdapterDataSet(list: ArrayList<AchievementsModel>) {
//        _items = list
//    }
//
//    fun clearAdapterDataSet() {
//        _items = FakeEmptyDataSource.createDataSet()
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            Badge_ViewType -> {
                getMedalViewHolder(parent)
            }
            Header_ViewType -> {
                getHeaderViewHolder(parent)
            }
            else -> {
                HeaderViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.layout_header_list_item, parent, false)
                )
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MedalViewHolder -> {
                holder.bind(_items[position], position, clickListener)
            }
            is HeaderViewHolder -> {
                holder.bind(_items[position], position)
            }
        }
    }

    override fun getItemCount(): Int {
        return _items.size
    }

    override fun getItemViewType(position: Int): Int {

        return when (_items[position].header) {
            null -> {
                Badge_ViewType
            }  // badge
            else -> {
                Header_ViewType
            } // header
        }
    }

    private fun getMedalViewHolder(parent: ViewGroup) = MedalViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_badge_list_item, parent, false)
    )

    private fun getHeaderViewHolder(parent: ViewGroup) = HeaderViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_header_list_item, parent, false)
    )


    class HeaderViewHolder constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        private val badge_header: TextView = itemView.header_title

        fun bind(achievementsModel: AchievementsModel, position: Int) {
            badge_header.text = achievementsModel.header
        }
    }

    class MedalViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val badge_image: ImageView = itemView.badge_image
        private val badge_title: TextView = itemView.badge_title
        private val badge_description: TextView = itemView.badge_description
//        val badge_header: TextView = itemView.header_title

        private fun setView(achievementModel: AchievementsModel, requestOptions: RequestOptions) {
            achievementModel.image.let {
                Glide.with(itemView.context)
                    .applyDefaultRequestOptions(requestOptions)
                    .load(achievementModel.imageUrl)
                    .into(badge_image)
            }
            badge_title.text = achievementModel.title
            badge_description.text = achievementModel.description

        }

        fun bind(achievementModel: AchievementsModel, position: Int, action: OnClickListener) {
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            setView(achievementModel, requestOptions)

            when (achievementModel.description) {
                "NA" -> {
                    badge_image.fadeOut()
                    badge_title.fadeOut()
                    badge_description.fadeOut()
                }
                else -> {
                    badge_image.fadeIn()
                    badge_title.fadeIn()
                    badge_description.fadeIn()
                    badge_image.setOnClickListener { action.onItemClicked(achievementModel, position) }
                }
            }
        }
    }

    companion object {
        private const val Header_ViewType: Int = 0
        private const val Badge_ViewType: Int = 1
    }
}