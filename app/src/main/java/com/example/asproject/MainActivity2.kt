package com.example.asproject

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.RadioButton
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main3.*

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

    fun exit(view: View?)
    {
        finish()
    }

    fun theme(view: View?)
    {
        gl.setBackgroundColor(Color.parseColor("#636363"))
    }

}