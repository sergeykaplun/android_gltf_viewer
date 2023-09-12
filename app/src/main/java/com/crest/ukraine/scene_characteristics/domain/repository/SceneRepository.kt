package com.crest.ukraine.scene_characteristics.domain.repository

import com.crest.ukraine.scene_characteristics.domain.model.SceneList

interface SceneRepository {
    suspend fun getScenes(): List<SceneList>
}