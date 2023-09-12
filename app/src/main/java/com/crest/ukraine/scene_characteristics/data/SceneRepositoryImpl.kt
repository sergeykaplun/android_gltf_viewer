package com.crest.ukraine.scene_characteristics.data

import com.crest.ukraine.scene_characteristics.domain.model.SceneItem
import com.crest.ukraine.scene_characteristics.domain.model.SceneList
import com.crest.ukraine.scene_characteristics.domain.repository.SceneRepository

class SceneRepositoryImpl : SceneRepository {

    private val listsScenes: Map<String, List<String>> = ScenesDataSource.createScenesData()
    override suspend fun getScenes(): List<SceneList> {

//        return listsScenes.keys.map { categoryName ->
//            val sceneArray = listsScenes[categoryName] ?: emptyList()
//            val sceneList = sceneArray.map { sceneItemString ->
//                val itemParts = sceneItemString.split("|")
//                SceneItem(
//                    title = itemParts[0],
//                    imageName = itemParts[1],
//                    assetName = itemParts[2]
//                )
//            }
//            SceneList(categoryName, sceneList)
//        }

        val listCategoryNames = listsScenes.keys.toList()
        val allLists = mutableListOf<SceneList>()

        for (categoryName in listCategoryNames) {
            val sceneArray = listsScenes[categoryName] ?: emptyList()
            val sceneList = mutableListOf<SceneItem>()

            for (sceneItemString in sceneArray) {
                val itemParts = sceneItemString.split("|")
                val sceneItem = SceneItem(
                    title = itemParts[0],
                    imageName = itemParts[1],
                    assetName = itemParts[2]
                )
                sceneList.add(sceneItem)
            }
            allLists.add(SceneList(categoryName, sceneList))
        }
        return allLists
    }
}