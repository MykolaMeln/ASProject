package com.example.asproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun chbClick(view: View?)
    {
        Toast.makeText(this, "Why did you click?", Toast.LENGTH_SHORT).show()
    }
    fun toActivity2(view: View?) {
        val intent = Intent(this@MainActivity, MainActivity2::class.java)
        startActivity(intent)
    }
}