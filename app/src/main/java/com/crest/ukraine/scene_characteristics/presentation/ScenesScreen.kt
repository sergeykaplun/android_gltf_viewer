package com.crest.ukraine.scene_characteristics.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.crest.ukraine.scene_characteristics.presentation.components.SceneCardList


@Composable
fun ScenesScreen(
    navController: NavController,
    viewModel: ScenesViewModel
) {
    val sceneItems by viewModel.sceneItems.collectAsState()

    LazyColumn() {
        item {
            SceneCardList(navController = navController, scenes = sceneItems, scenesTitle = "Pilot helmet 1")
            SceneCardList(navController = navController, scenes = sceneItems, scenesTitle = "Flight helmet 2")
            SceneCardList(navController = navController, scenes = sceneItems, scenesTitle = "Pilot helmet 3")
            SceneCardList(navController = navController, scenes = sceneItems, scenesTitle = "Flight helmet 4")
            SceneCardList(navController = navController, scenes = sceneItems, scenesTitle = "Pilot helmet 5")
            SceneCardList(navController = navController, scenes = sceneItems, scenesTitle = "Pilot helmet 6")
        }
    }
}

