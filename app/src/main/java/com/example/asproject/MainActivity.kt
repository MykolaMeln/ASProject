package com.example.asproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.asproject.screens.about.about
import com.example.asproject.screens.addgoods.AddGoodsFragment
import com.example.asproject.screens.category.category
import com.example.asproject.screens.elements.ElementsFragment
import com.example.asproject.screens.termsofuse.terms_of_use
import timber.log.Timber

const val timer1 = ""
const val timer2 = ""

var t1 = 0
var t2 = 0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycle.addObserver(Observer(lifecycle))

        if(savedInstanceState!=null)
        {
            Timber.i("onSaveInstanceState Called")
            t1 = savedInstanceState.getInt(timer1)
            t2 = savedInstanceState.getInt(timer2)
        }
        else
        {
            t1 = 0
            t2 = 0
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Timber.i("onSaveInstanceState Called")
        outState.putInt(timer1, t1)
        outState.putInt(timer2, t2)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Timber.i("onRestoreInstanceState Called")

        t1 = savedInstanceState.getInt(timer1.toString())
        t2 = savedInstanceState.getInt(timer2.toString())
    }

    override fun onStart() {
        super.onStart()
        Timber.i("onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("onStop Called")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_categories -> {
                val newFragment =
                    category()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.linearLayout, newFragment)
                transaction.addToBackStack(null)
                transaction.commit()
                true
            }
            R.id.action_terms_of_use -> {
                val newFragment =
                    terms_of_use()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.linearLayout, newFragment)
                transaction.addToBackStack(null)
                transaction.commit()
                true
            }
            R.id.action_about -> {
                val newFragment = about()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.linearLayout, newFragment)
                transaction.addToBackStack(null)
                transaction.commit()
                true
            }
            R.id.action_elements -> {
                val newFragment =
                    ElementsFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.linearLayout, newFragment)
                transaction.addToBackStack(null)
                transaction.commit()
                true
            }
            R.id.action_add -> {
                val newFragment =
                   AddGoodsFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.linearLayout, newFragment)
                transaction.addToBackStack(null)
                transaction.commit()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    fun chbClick(view: View?)
    {
        Toast.makeText(this, "Why did you click?", Toast.LENGTH_SHORT).show()
    }
}

