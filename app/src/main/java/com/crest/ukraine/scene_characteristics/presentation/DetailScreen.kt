package com.crest.ukraine.scene_characteristics.presentation

import android.annotation.SuppressLint
import android.app.WallpaperManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import com.crest.ukraine.CrestSurfaceView
import com.crest.ukraine.R
import com.crest.ukraine.scene_characteristics.presentation.navigation.Screens
import com.crest.ukraine.wallpaper.CrestWallpaperService
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailScreen(
    navHostController: NavHostController,
    crestSurfaceView: CrestSurfaceView,
    context: Context
) {

    var isMenuExpanded by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = stringResource(id = R.string.scenes))
                    },
                    backgroundColor = Color.LightGray,
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                coroutineScope.launch {
                                    navHostController.navigate(Screens.ScenesScreen.route)
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = stringResource(id = R.string.go_back)
                            )
                        }
                    },
                    actions = {
                        IconButton(
                            onClick = {
                                isMenuExpanded = !isMenuExpanded
                            }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = stringResource(id = R.string.menu)
                            )
                        }
                        DropdownMenu(
                            expanded = isMenuExpanded,
                            onDismissRequest = { isMenuExpanded = false },
                            modifier = Modifier
                                .background(Color.LightGray.copy(0.5f))
                        ) {
                            DropdownMenuItem(
                                onClick = {
                                    coroutineScope.launch {
                                        startWallpaperChange(context = context)
                                        isMenuExpanded = false
                                    }
                                }) {
                                Text(stringResource(id = R.string.title_of_button_to_set_wallpaper))
                            }
                        }
                    }
                )
            }
        ) { paddingValues ->
            AndroidView(
                factory = { crestSurfaceView },
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            )
        }
    }
}

private fun startWallpaperChange(context: Context) {
    val intent = Intent(WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER)
    intent.putExtra(
        WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT,
        ComponentName(context, CrestWallpaperService::class.java)
    )
    context.startActivity(intent)
}

