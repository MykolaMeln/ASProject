package com.example.asproject

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import timber.log.Timber
import java.util.*
import kotlin.math.round

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
        Timber.i(("Y: "+(t2.toFloat()).toString() +"с. час роботи додатку. "+ " X:"+ (t1.toFloat()).toString() +" "+ round(t1.toFloat() / t2.toFloat() * 100)).toString() + "% додаток був у фокусі.")
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