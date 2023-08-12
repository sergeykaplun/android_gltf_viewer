package com.crest.ukraine.scene_characteristics.domain.model

import androidx.navigation.NavController

data class SceneList(
    val scenesListTitle: String,
    val scenesList: List<SceneItem>,
    val navController: NavController
)
