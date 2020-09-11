package com.example.achievements.ui.detailed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.achievements.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_detailed.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 * any detailed feature related to the item that gets clicked in the recyclerview will be shown here
 * at this point this is just a simple screen to show the concept.
 */

@AndroidEntryPoint
class DetailedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_detailed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imgUrl  =arguments?.getSerializable("url")
        val badgeTitle  =arguments?.getString("title")
        Glide.with(view.context)
//            .applyDefaultRequestOptions(requestOptions)
            .load(imgUrl)
            .into(imageView)
        titleDetail.text = badgeTitle

            view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }
}