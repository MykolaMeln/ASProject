package com.example.asproject

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_categories.*
import kotlinx.android.synthetic.main.activity_main3.*

class Categories : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
    }

    fun toActivity1(view: View?) {
        val intent = Intent(this@Categories, MainActivity::class.java)
        startActivity(intent)
    }

    fun toActivity3(view: View?) {
        val intent = Intent(this@Categories, MainActivity3::class.java)
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

    fun presscategory(view: View?)
    {
        val myButton = findViewById<View>(view!!.id) as Button

        Toast.makeText(applicationContext, myButton.text, Toast.LENGTH_SHORT).show()
    }

}