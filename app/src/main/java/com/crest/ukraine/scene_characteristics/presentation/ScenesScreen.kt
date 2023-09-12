package com.crest.ukraine.scene_characteristics.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
    val listListsScenesState by viewModel.sceneItems.collectAsState()

    LazyColumn {
        items(listListsScenesState) { sceneList ->
            SceneCardList(
                navController = navController,
                scenes = sceneList.scenesList,
                scenesTitle = sceneList.scenesListTitle
            )
        }
    }
}


