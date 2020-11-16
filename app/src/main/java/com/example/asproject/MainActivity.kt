package com.example.asproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import timber.log.Timber
import java.util.*
import kotlin.math.round

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
                val newFragment = category()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.linearLayout, newFragment)
                transaction.addToBackStack(null)
                transaction.commit()
                true
            }
            R.id.action_terms_of_use -> {
                val newFragment = terms_of_use()
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
                val newFragment = elements()
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

class Observer(lifecycle: Lifecycle) : LifecycleObserver {

    var timer = Timer()
    var timer2 = Timer()

    init {
        lifecycle.addObserver(this)
    }

    var task = object : TimerTask() {
        override fun run() = Timber.i("timer passed ${++t1} time(s)")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun connectListener() {
        Timber.i("onResume")
        timer = Timer()
        task = object : TimerTask() {
            override fun run() = Timber.i("timer passed ${++t1} time(s)")
        }
        timer.schedule(task, 0, 1000)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun disconnectListener() {
        Timber.i("onPause")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun destroyListener() {
        Timber.i("onDestroy")
        timer2.cancel()
        Timber.i(((t1.toFloat()).toString() +"с. час роботи додатку. "+ " Y:"+ (t2.toFloat()).toString() +" "+ round(t1.toFloat() / t2.toFloat() * 100)).toString() + "% додаток був у фокусі.")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun createListener() {
        Timber.i("onCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stopListener() {
        Timber.i("onStop")
        timer.cancel()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun startListener() {
        Timber.i("onCreate")
        Timber.i("onStart")
        timer2 = Timer()
        task = object : TimerTask() {
            override fun run(): Unit {
                (++t2)
            }
        }
        timer2.schedule(task, 0, 1000)
    }
}