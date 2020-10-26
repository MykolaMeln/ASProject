package com.example.asproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main3.*


class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
    }

    fun toActivity2(view: View?) {
        val intent = Intent(this@MainActivity3, Categories::class.java)
        startActivity(intent)
    }

    fun showChecked(view: View?)
    {
        val checkedRadioButtonId: Int = radioGroup.getCheckedRadioButtonId()
        val myRadioButton = findViewById<View>(checkedRadioButtonId) as RadioButton

        Toast.makeText(applicationContext, myRadioButton.text, Toast.LENGTH_SHORT).show()
    }

}