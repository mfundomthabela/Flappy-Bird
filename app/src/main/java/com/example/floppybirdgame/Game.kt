package com.example.floppybirdgame

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.MotionEvent

class Game(context: Context) : SurfaceView(context), Runnable {
    private val thread = Thread(this)
    private var isPlaying = true
    private val bird: Bird = Bird(context)
    private val pillars: MutableList<Pillar> = mutableListOf()
    private var score = 0
    private val paint = Paint() // If you plan to use this, otherwise consider removing it
    private val surfaceHolder: SurfaceHolder = holder

    init {
        for (i in 0..5) {
            pillars.add(Pillar(context, height))
        }
        thread.start()
    }

    override fun run() {
        while (isPlaying) {
            update()
            draw()
            control()
        }
    }

    private fun update() {
        bird.update()
        for (pillar in pillars) {
            pillar.update()
            if (pillar.isOffScreen()) {
                score++
                pillars.remove(pillar)
                pillars.add(Pillar(context, height))
            }
        }
    }

    private fun draw() {
        if (surfaceHolder.surface.isValid) {
            val canvas: Canvas = surfaceHolder.lockCanvas()
            canvas.drawColor(Color.CYAN) // Background color
            bird.draw(canvas)
            for (pillar in pillars) {
                pillar.draw(canvas)
            }
            surfaceHolder.unlockCanvasAndPost(canvas)
        }
    }

    private fun control() {
        try {
            Thread.sleep(17)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            bird.flap()
            performClick() // Call performClick for accessibility
        }
        return true
    }

    fun pause() {
        isPlaying = false
        thread.join()
    }

    fun resume() {
        isPlaying = true
        thread.start()
    }
}
