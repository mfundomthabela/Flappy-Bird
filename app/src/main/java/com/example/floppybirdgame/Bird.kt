package com.example.floppybirdgame

import android.graphics.Bitmap

class Bird(val bitmap: Bitmap, var x: Int, var y: Int) {
    private var gravity = 5

    fun update() {
        y += gravity
        // Add jumping logic (you can modify this)
        if (y > 800) { // Assuming 800 is the screen height limit
            y = 800
        }
    }
}
