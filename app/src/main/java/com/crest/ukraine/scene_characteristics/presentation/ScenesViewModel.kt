package com.crest.ukraine.scene_characteristics.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.crest.ukraine.scene_characteristics.domain.model.SceneList
import com.crest.ukraine.scene_characteristics.domain.repository.SceneRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ScenesViewModel(private val repository: SceneRepository) : ViewModel() {
    private val _sceneItems = MutableStateFlow<List<SceneList>>(emptyList())
    val sceneItems: StateFlow<List<SceneList>> = _sceneItems
    init {
        viewModelScope.launch {
            _sceneItems.value = repository.getScenes()
        }
    }
}


class ScenesViewModelFactory( private val repository: SceneRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScenesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ScenesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}