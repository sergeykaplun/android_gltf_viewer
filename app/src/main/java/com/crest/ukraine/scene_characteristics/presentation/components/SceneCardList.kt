package com.crest.ukraine.scene_characteristics.presentation.components

import android.transition.Scene
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.crest.ukraine.scene_characteristics.domain.model.SceneItem
import com.crest.ukraine.scene_characteristics.domain.model.SceneList

@Composable
fun SceneCardList(
    navController: NavController,
    scenes: List<SceneItem>,
    scenesTitle: String
) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column() {
            Text(
                text = scenesTitle,
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 2.dp)
            ) {
                    items(
                        items = scenes,
                        itemContent = { sceneItem ->
                            SceneListItem(sceneItem = sceneItem, navController = navController)
                        }
                    )
            }
        }
    }
}
