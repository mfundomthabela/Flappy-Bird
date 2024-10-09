package com.example.floppybirdgame

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint

class Bird(private val context: Context) {
    private var birdY = 0
    private var birdBitmap: Bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.bird)
    private var velocity = 0
    private val gravity = 1

    fun update() {
        birdY += velocity
        velocity += gravity
        if (birdY < 0) birdY = 0 // Keep bird within the top of the screen
    }

    fun flap() {
        velocity = -20 // Move the bird upwards
    }

    fun draw(canvas: Canvas) {
        canvas.drawBitmap(birdBitmap, 100f, birdY.toFloat(), Paint())
    }

    fun getY(): Int {
        return birdY
    }

    fun getWidth(): Int {
        return birdBitmap.width
    }

    fun getHeight(): Int {
        return birdBitmap.height
    }
}
