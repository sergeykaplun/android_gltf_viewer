package com.crest.ukraine.scene_characteristics.presentation.components

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.crest.ukraine.R
import com.crest.ukraine.scene_characteristics.domain.model.SceneItem
import com.crest.ukraine.scene_characteristics.presentation.navigation.Screens

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SceneListItem(
    sceneItem: SceneItem,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .padding(top = 8.dp, start = 8.dp, end = 8.dp, bottom = 16.dp)
            .fillMaxSize(),
        elevation = 4.dp,
        shape = RoundedCornerShape(corner = CornerSize(6.dp)),
        backgroundColor = Color.LightGray,
        onClick = {
            navController.navigate(Screens.DetailScreen.route)
        }
    ){
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.pilot_helmet),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(2.dp)
                    .height(150.dp)
                    .width(110.dp)
                    .clip(RoundedCornerShape(corner = CornerSize(6.dp)))
            )
            Text(
                text = sceneItem.title,
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .padding(start = 4.dp),
            )
        }
    }
}
