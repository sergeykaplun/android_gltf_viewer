package com.crest.ukraine.scene_characteristics.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.crest.ukraine.CrestSurfaceView
import com.crest.ukraine.scene_characteristics.presentation.DetailScreen
import com.crest.ukraine.scene_characteristics.presentation.MainActivity
import com.crest.ukraine.scene_characteristics.presentation.ScenesScreen
import com.crest.ukraine.scene_characteristics.presentation.ScenesViewModel

@Composable
fun MyNavHost(
    navHostController: NavHostController,
    context: MainActivity,
    viewModel: ScenesViewModel
) {
    NavHost(navController = navHostController, startDestination = Screens.ScenesScreen.route) {
        composable(route = Screens.ScenesScreen.route) {
            ScenesScreen(navController = navHostController, viewModel = viewModel)
        }
        composable(
            route = Screens.DetailScreen.route + "?assetName={assetName}",
            arguments = listOf(
                navArgument("assetName") {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            val assetName = entry.arguments?.getString("assetName") ?: ""
            DetailScreen(
                navHostController = navHostController,
                crestSurfaceView = CrestSurfaceView(context = context, assetName = assetName),
                context = context
            )
        }

    }
}