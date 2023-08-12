package com.crest.ukraine.scene_characteristics.data

import com.crest.ukraine.R
import com.crest.ukraine.scene_characteristics.domain.model.SceneItem
import com.crest.ukraine.scene_characteristics.domain.repository.SceneRepository

class SceneRepositoryImpl : SceneRepository {

    override suspend fun getScenes(): List<SceneItem> {

        val scenes = mutableListOf<SceneItem>()

         for (i in 1..10){
             val item = SceneItem("Pilot helmet ${i}", R.drawable.pilot_helmet, "")
             scenes.add(item)
         }
        return scenes
    }

    override suspend fun getScene(title: String): SceneItem? {
        TODO("Not yet implemented")
    }

}