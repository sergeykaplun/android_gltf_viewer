package com.crest.ukraine

import android.content.res.AssetManager
import android.view.Surface

class JNITie {
    companion object{
        const val INITIALIZED: Boolean = false
    }
    init {
        if(!INITIALIZED)
            System.loadLibrary("wgpu_template_app")
    }

    external fun createNativeScene(surface: Surface, assetManager: AssetManager): Long
    external fun drawFrame(sceneObj: Long)
    external fun handleEvent(sceneObj: Long, action: Int, x: Float, y: Float)

    //external fun drawFrame(sceneObj: Long)
    //external fun changeExample(rustObj: Long, idx: Int)
    //external fun dropWgpuCanvas(rustObj: Long)
}
