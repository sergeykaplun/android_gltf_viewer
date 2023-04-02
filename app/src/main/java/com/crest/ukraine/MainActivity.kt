package com.crest.ukraine

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.crest.ukraine.ui.theme.CrestTheme
import com.crest.ukraine.ui.theme.ImageCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val painter = painterResource(id = R.drawable.helmet)
            val title = "flight helmet"
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                ImageCard(painter = painter, contentDescription = title)

            }
//            CrestTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
//                    SceneView()
//                }
//            }
        }
    }
}

@Composable
fun SceneView() {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    AndroidView(
        factory = { ctx ->
            CrestSurfaceView(context = ctx)
            //surfaceView = sv
            //sv
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(screenWidth),
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CrestTheme {
        SceneView()
    }
}