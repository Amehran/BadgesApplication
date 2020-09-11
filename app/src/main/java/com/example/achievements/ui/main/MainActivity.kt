package com.example.achievements.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import com.example.achievements.R
import com.example.achievements.ui.achievements.AchievementsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: AchievementsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    /***
     * mainly will be used the proposed MVI pattern. the recyclerView feed can be cleared, reloaded  etc.
     * basically it can act as normal menu but based on MVI pattern
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.load_list_adapter -> {
                // to be implemented when migrating to MVI
                CoroutineScope(Dispatchers.IO).launch {  viewModel.reloadData()}
                return true
            }
            R.id.clear_local_cache -> {
                // to be implemented when migrating to MVI
                CoroutineScope(Dispatchers.IO).launch {  viewModel.clear()}
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}