package com.example.floppybirdgame

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Start Landing activity
        startActivity(Intent(this, Landing::class.java))
        finish()
    }
}