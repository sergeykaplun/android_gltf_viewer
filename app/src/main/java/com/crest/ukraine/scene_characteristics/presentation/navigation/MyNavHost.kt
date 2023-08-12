package com.crest.ukraine.scene_characteristics.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.crest.ukraine.CrestSurfaceView
import com.crest.ukraine.scene_characteristics.presentation.DetailScreen
import com.crest.ukraine.scene_characteristics.presentation.MainActivity
import com.crest.ukraine.scene_characteristics.presentation.ScenesScreen
import com.crest.ukraine.scene_characteristics.presentation.ScenesViewModel

@Composable
fun MyNavHost(navHostController: NavHostController, context: MainActivity, viewModel: ScenesViewModel) {
    NavHost(navController = navHostController, startDestination = Screens.ScenesScreen.route) {
        composable(route = Screens.ScenesScreen.route) {
            ScenesScreen(navController = navHostController, viewModel)
        }
        composable(route = Screens.DetailScreen.route){
            DetailScreen(navHostController = navHostController, crestSurfaceView = CrestSurfaceView(context = context))
        }
//        composable(
//            route = Screens.DetailScreen.route + "/{str}",
//            arguments = listOf(
//                navArgument("str"){
//                    type = NavType.StringType
//                }
//            )
//        ){ entry ->
//            entry.arguments?.getString("str")?.let {
//                DetailScreen(navHostController = navHostController, crestSurfaceView = CrestSurfaceView(context = context))
//            }
//        }

    }
}