package com.crest.ukraine.scene_characteristics.presentation.navigation

sealed class Screens(val route: String) {
    object ScenesScreen: Screens("main_screen")
    object DetailScreen: Screens("detail_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach {arg ->
                append("/$arg")
            }
        }
    }
}
