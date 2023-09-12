package com.crest.ukraine.wallpaper

import android.service.wallpaper.WallpaperService
import android.view.SurfaceHolder
import com.crest.ukraine.JNITie

class CrestWallpaperService : WallpaperService() {

    override fun onCreateEngine(): WallpaperService.Engine {
        return WallpaperEngine()
    }

    inner class WallpaperEngine() : WallpaperService.Engine() {

        private var nativeSceneObject: Long? = null
        private lateinit var jniTie: JNITie
        override fun onCreate(surfaceHolder: SurfaceHolder?) {
            super.onCreate(surfaceHolder)
            jniTie = JNITie("assetName")
        }

        override fun onSurfaceChanged(
            holder: SurfaceHolder?,
            format: Int,
            width: Int,
            height: Int
        ) {
            super.onSurfaceChanged(holder, format, width, height)
            // Дополнительная логика при изменении поверхности
        }

        override fun onSurfaceRedrawNeeded(holder: SurfaceHolder?) {
            super.onSurfaceRedrawNeeded(holder)
            // Дополнительная логика при необходимости перерисовки поверхности
            nativeSceneObject?.let { obj ->
                jniTie.drawFrame(obj)
            }
        }

        override fun onSurfaceCreated(holder: SurfaceHolder?) {
            super.onSurfaceCreated(holder)
            nativeSceneObject = jniTie.create(holder!!.surface, this@CrestWallpaperService.assets)
            // Дополнительная логика при создании поверхности

        }

        override fun onOffsetsChanged(
            xOffset: Float,
            yOffset: Float,
            xOffsetStep: Float,
            yOffsetStep: Float,
            xPixelOffset: Int,
            yPixelOffset: Int
        ) {
            super.onOffsetsChanged(
                xOffset,
                yOffset,
                xOffsetStep,
                yOffsetStep,
                xPixelOffset,
                yPixelOffset
            )
            // Дополнительная логика при изменении смещения
        }

        override fun onVisibilityChanged(visible: Boolean) {
            super.onVisibilityChanged(visible)
            if (visible) {
                // Видимость живых обоев изменилась на "видимо"
            } else {
                // Видимость живых обоев изменилась на "не видимо"
            }
        }

        override fun onDestroy() {
            super.onDestroy()
            // Логика при завершении работы живых обоев
        }

    }

}


