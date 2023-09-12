package com.crest.ukraine.scene_characteristics.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.crest.ukraine.R
import com.crest.ukraine.scene_characteristics.data.SceneRepositoryImpl
import com.crest.ukraine.scene_characteristics.presentation.navigation.MyNavHost
import com.crest.ukraine.ui.theme.CrestTheme


class MainActivity : ComponentActivity() {

    private val repository = SceneRepositoryImpl()
    private val scenesViewModel: ScenesViewModel by viewModels {
        ScenesViewModelFactory(repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = getColor(R.color.dark_gray)
        setContent {
            CrestTheme{
                val navController = rememberNavController()
                val context = this@MainActivity

                MyNavHost(
                    navHostController = navController,
                    context = context,
                    viewModel = scenesViewModel
                )
            }
        }
    }
}

