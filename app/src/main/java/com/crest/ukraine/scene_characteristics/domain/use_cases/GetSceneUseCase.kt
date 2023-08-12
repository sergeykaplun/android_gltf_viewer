package com.crest.ukraine.scene_characteristics.domain.use_cases

import com.crest.ukraine.scene_characteristics.domain.repository.SceneRepository

class GetSceneUseCase(
    private val repository: SceneRepository
) {
    operator fun invoke(title: String) {

    }
}