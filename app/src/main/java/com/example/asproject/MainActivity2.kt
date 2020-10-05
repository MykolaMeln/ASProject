package com.example.asproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    fun toActivity1(view: View?) {
        val intent = Intent(this@MainActivity2, MainActivity::class.java)
        startActivity(intent)
    }

    fun toActivity3(view: View?) {
        val intent = Intent(this@MainActivity2, MainActivity3::class.java)
        startActivity(intent)
    }

}