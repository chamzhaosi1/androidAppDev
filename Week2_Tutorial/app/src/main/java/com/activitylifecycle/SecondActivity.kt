package com.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class SecondActivity : AppCompatActivity() {
    val TAG = "SecondActivityLog"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    override fun onRestart() {
        Log.d(TAG, "onRestart")
        super.onRestart()
    }

    override fun onStart(){
        Log.d(TAG, "onStart")
        super.onStart()
    }

    override fun onResume(){
        Log.d(TAG, "onResume")
        super.onResume()
    }

    override fun onPause(){
        Log.d(TAG, "onPause")
        super.onPause()
    }

    override fun onStop(){
        Log.d(TAG, "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }
}