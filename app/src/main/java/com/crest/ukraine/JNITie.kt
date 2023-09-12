package com.crest.ukraine

import android.content.res.AssetManager
import android.view.Surface

class JNITie(private val assetName: String) {
    companion object {
        var INITIALIZE = false
    }

    init {
        if (!INITIALIZE) {
            System.loadLibrary("wgpu_template_app")
            INITIALIZE = true
        }
    }

    fun create(surface: Surface, assetManager: AssetManager): Long
    {
//        return createNativeScene(surface, assetManager)
        return createNativeScene(surface, assetManager, assetName)
    }

    private external fun createNativeScene(surface: Surface, assetManager: AssetManager): Long
    private external fun createNativeScene(surface: Surface, assetManager: AssetManager, assetNAme: String): Long
    external fun drawFrame(sceneObj: Long)
    external fun handleEvent(sceneObj: Long, action: Int, x: Float, y: Float)

    //external fun drawFrame(sceneObj: Long)
    //external fun changeExample(rustObj: Long, idx: Int)
    //external fun dropWgpuCanvas(rustObj: Long)
}
