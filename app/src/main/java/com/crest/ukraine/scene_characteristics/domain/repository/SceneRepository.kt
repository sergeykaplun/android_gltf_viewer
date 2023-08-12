package com.crest.ukraine.scene_characteristics.domain.repository

import com.crest.ukraine.scene_characteristics.domain.model.SceneItem
import kotlinx.coroutines.flow.Flow

interface SceneRepository {
    suspend fun getScenes(): List<SceneItem>
    suspend fun getScene(title: String): SceneItem?
}