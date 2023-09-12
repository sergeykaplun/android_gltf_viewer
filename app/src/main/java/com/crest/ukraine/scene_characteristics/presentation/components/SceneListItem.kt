package com.crest.ukraine.scene_characteristics.presentation.components

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.crest.ukraine.R
import com.crest.ukraine.scene_characteristics.domain.model.SceneItem
import com.crest.ukraine.scene_characteristics.presentation.navigation.Screens
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SceneListItem(
    sceneItem: SceneItem,
    navController: NavController
) {
    val scope = rememberCoroutineScope()
    Card(
        modifier = Modifier
            .padding(top = 8.dp, start = 8.dp, end = 8.dp, bottom = 16.dp)
            .fillMaxSize(),
        elevation = 4.dp,
        shape = RoundedCornerShape(corner = CornerSize(6.dp)),
        backgroundColor = Color.LightGray,
        onClick = {
            scope.launch {
                navController.navigate(Screens.DetailScreen.route + "?assetName=${sceneItem.assetName}")
            }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AssetImage(imageName = sceneItem.imageName, contentDescription = sceneItem.title)
            Text(
                text = sceneItem.title,
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .padding(start = 4.dp),
            )
        }
    }
}

@Composable
fun AssetImage(imageName: String, contentDescription: String) {

    val context = LocalContext.current
    val assetManager = context.assets
    val inputStream = assetManager.open(imageName)
    val imageBitmap = BitmapFactory.decodeStream(inputStream).asImageBitmap()

    Image(
        bitmap = imageBitmap,
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(2.dp)
            .height(150.dp)
            .width(110.dp)
            .clip(RoundedCornerShape(6.dp))
    )
}