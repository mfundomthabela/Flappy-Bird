package com.example.floppybirdgame


import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import kotlin.random.Random

class Pillar(private val context: Context, private val screenHeight: Int) {
    private var pillarX = screenHeight
    private var gap = 400
    private var pillarHeight = Random.nextInt(200, 800)
    private var pillarBitmap: Bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.pillar)

    fun update() {
        pillarX -= 10
    }

    fun draw(canvas: Canvas) {
        canvas.drawBitmap(pillarBitmap, pillarX.toFloat(), (screenHeight - pillarHeight).toFloat(), Paint())
        canvas.drawBitmap(pillarBitmap, pillarX.toFloat(), (screenHeight - pillarHeight - gap - pillarBitmap.height).toFloat(), Paint())
    }

    fun getX(): Int {
        return pillarX
    }

    fun getGap(): Int {
        return gap
    }

    fun getHeight(): Int {
        return pillarHeight
    }

    fun isOffScreen(): Boolean {
        return pillarX < -pillarBitmap.width
    }
}
