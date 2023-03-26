package com.crest.ukraine

import android.content.Context
import android.graphics.Canvas
import android.graphics.PixelFormat
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView

class CrestSurfaceView: SurfaceView, SurfaceHolder.Callback2 {
    private var jniTie = JNITie()
    private var nativeSceneObject: Long? = null

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    )
    init {
        holder.addCallback(this)
        this.setZOrderOnTop(true)
        holder.setFormat(PixelFormat.TRANSPARENT)
    }

    override fun surfaceCreated(p0: SurfaceHolder) {
        holder.let { h ->
            nativeSceneObject = jniTie.createNativeScene(h.surface, context.assets)
            setWillNotDraw(false)
        }
    }

    override fun surfaceChanged(p0: SurfaceHolder, p1: Int, p2: Int, p3: Int) {

    }

    override fun surfaceDestroyed(p0: SurfaceHolder) {
        nativeSceneObject.let {
            //jniTie.dropWgpuCanvas(nativePtr)
            nativeSceneObject = null
        }
    }

    override fun surfaceRedrawNeeded(p0: SurfaceHolder) {

    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        nativeSceneObject?.let { obj ->
            jniTie.drawFrame(obj)
            invalidate()
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        nativeSceneObject?.let { obj ->
            jniTie.handleEvent(obj, event!!.action, event.x, event.y)
        }
        return true
    }
}
