package com.crest.ukraine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.crest.ukraine.ui.theme.CrestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CrestTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    SceneView()
                }
            }
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