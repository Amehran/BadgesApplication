package com.example.achievements.ui.achievements

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.achievements.R
import com.example.achievements.data_source.fake_data.FakeEmptyDataSource
import com.example.achievements.ui.main.state.AchievementsModel
import com.example.achievements.ui.main.state.MainViewState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_achievements.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
@AndroidEntryPoint
class AchievementsFragment : Fragment(), OnClickListener {
    // these can also be constructor injected using hilt and FragmentFactory
    private lateinit var achievementsRecyclerViewAdaptor: AchievementsRecyclerViewAdaptor
    private val viewModel: AchievementsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_achievements, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeObservers()
    }

    private fun initRecyclerView(dataSet: ArrayList<AchievementsModel>) {
        medal_list.apply {
            layoutManager = GridLayoutManager(
                this@AchievementsFragment.context,
                2,
                GridLayoutManager.VERTICAL,
                false
            )
            achievementsRecyclerViewAdaptor = AchievementsRecyclerViewAdaptor(dataSet, this@AchievementsFragment)
            adapter = achievementsRecyclerViewAdaptor
        }
    }

    private fun subscribeObservers() {

        viewModel.badges.observe(viewLifecycleOwner, { state ->
            when (state.message) {
                getString(R.string.Success) -> {
                    initRecyclerView(state.data!!)
                 }
                else -> {
                    Toast.makeText(
                        activity, "error in getting data from network",
                        Toast.LENGTH_LONG
                    ).show()
                    initRecyclerView(MainViewState("", FakeEmptyDataSource.createDataSet()).data!!)
                 }
            }
        })


    }

    override fun onItemClicked(item: AchievementsModel, position: Int) {
        val bundle = bundleOf("title" to item.title, "url" to item.imageUrl)
        findNavController()
            .navigate(R.id.DetailedFragment, bundle)
    }

    override fun onDestroy() {
        super.onDestroy()
        unSubscribeObservers()
    }

    private fun unSubscribeObservers() {

    }
}
